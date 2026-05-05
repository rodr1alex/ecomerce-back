package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.CartForPaymentDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.ProductReturned;
import com.springboot.backend.andres.usersapp.usersbackend.entities.*;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IDirectionRepository;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.ISaleRepository;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.ISaleStatusRepository;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class SaleService implements ISaleService{
  @Autowired
  private ISaleRepository saleRepository;
  @Autowired
  private ICartService cartService;
  @Autowired
  private IFinalProductService finalProductService;
  @Autowired
  private IDirectionRepository directionRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private ISaleStatusRepository saleStatusRepository;


  @Override
  public Sale findById(Long sale_id) {
    return this.saleRepository.findById(sale_id).get();
  }

  @Override
  public Sale createSale(CartForPaymentDTO cartDTO) {
    long CREATED_STATUS_ID = 1L;
    Sale sale = new Sale();
    Cart cartDB = this.cartService.createCart(cartDTO);
    cartDB.getOrderedProductList().forEach(item -> item.setOriginalquantity(item.getQuantity())); //Original quantity
    this.finalProductService.removeFromInventory(cartDTO.getProducts());
    sale.setDate(LocalDateTime.now());
    sale.setDirection(this.directionRepository.findById(cartDTO.getDirection_id()).get());
    sale.setCart(cartDB);
    sale.setStatus(saleStatusRepository.findById(CREATED_STATUS_ID).get());
    Sale saleDB = this.saleRepository.save(sale);
    cartDB.setSale(saleDB);
    this.cartService.saveCart(cartDB);
    return saleDB;
  }

  @Override
  public Sale modifySale(Long sale_id, List<ProductReturned> productReturnedList) {
    long CANCELED_STATUS_ID = 3L;
    long MODIFIED_STATUS_ID = 2L;

    this.finalProductService.addToInventory(productReturnedList);
    Sale saleDB = this.saleRepository.findById(sale_id).get();
    Cart cartModified = this.cartService.modifyCart(saleDB.getCart().getCart_id(), productReturnedList);
    Long statusId = Objects.equals(cartModified.getTotal(), 0) ? CANCELED_STATUS_ID : MODIFIED_STATUS_ID;
    saleDB.setStatus(saleStatusRepository.findById(statusId).get());

    return  this.saleRepository.save(saleDB);
  }

  @Override
  public Sale cancelSale(Long sale_id) {
    Sale saleDB = this.saleRepository.findById(sale_id).get();
    Cart cartDB = this.cartService.findById(saleDB.getCart().getCart_id());

    List<ProductReturned> productReturnedList = cartDB.getOrderedProductList()
      .stream()
      .map(item -> new ProductReturned(item.getFinalProduct().getFinal_product_id(), item.getQuantity()))
      .toList();

    return modifySale(sale_id, productReturnedList);
  }

  @Override
  public Page<Sale> filter(Pageable pageable, Long userId, LocalDateTime startDate, LocalDateTime endDate, Integer startTotal, Integer endTotal, Long statusId) {
    return saleRepository.filterSales(userId, statusId, startTotal, endTotal, startDate, endDate, pageable);
  }

  @Override
  public List<SaleStatus> getAllSaleStatus() {
    return (List<SaleStatus>) saleStatusRepository.findAll();
  }


}





