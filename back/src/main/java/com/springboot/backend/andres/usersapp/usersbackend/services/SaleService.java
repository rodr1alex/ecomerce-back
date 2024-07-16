package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.*;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IDirectionRepository;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.ISaleRepository;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

  @Override
  public Sale findById(Long sale_id) {
    return this.saleRepository.findById(sale_id).get();
  }

  @Override
  public Page<Sale> findAll(Pageable pageable) {
    return this.saleRepository.findAll(pageable);
  }

  @Override
  public Sale createSale(Long cart_id, Long direction_id, Long user_id) {
    Cart cartDB = this.cartService.findById(cart_id);
    User userDB = this.userRepository.findById(user_id).get();
    Direction directionDB = this.directionRepository.findById(direction_id).get();
    Sale sale = new Sale();
    List<OrderedProduct> orderedProductListDB = cartDB.getOrderedProductList();
    this.finalProductService.reduceInventory(orderedProductListDB);
    sale.setDate(LocalDateTime.now());
    sale.setDirection(directionDB);
    sale.setTotal(cartDB.getTotal());
    sale.setItems(cartDB.getItems());
    sale.setCart_id(cart_id);
    sale.setUsername(userDB.getUsername());
    sale.setUser_id(user_id);
    sale.setStatus("Realizada");
    sale = this.saleRepository.save(sale);
    cartDB.setSale(sale);
    this.cartService.saveCart(cartDB);
    return sale;
  }

  @Override
  public Cart returnProduct(OrderedProduct orderedProduct, Long sale_id) {
    Sale saleDB = this.saleRepository.findById(sale_id).get();
    Cart cartDB = this.cartService.findBySaleId(sale_id);
    OrderedProduct orderedProductOriginal = this.cartService.findOrderedProduct(orderedProduct.getFinalProduct().getFinal_product_id(), cartDB.getCart_id());
    Integer differential =orderedProduct.getQuantity() - orderedProductOriginal.getQuantity();
    this.cartService.UpdateProductQuantity(orderedProduct,cartDB.getCart_id());
    orderedProduct.setQuantity(differential);
    List<OrderedProduct> orderedProductList = new ArrayList<>();
    orderedProductList.add(orderedProduct);
    this.finalProductService.reduceInventory(orderedProductList);
    saleDB.setTotal(cartDB.getTotal());
    saleDB.setItems(cartDB.getItems());
    saleDB.setStatus("Modificada");
    this.saleRepository.save(saleDB);
    return cartDB;
  }

  @Override
  public Cart removeProduct(Long final_product_id, Long sale_id) {
    Sale saleDB = this.saleRepository.findById(sale_id).get();
    Cart cartDB = this.cartService.findBySaleId(sale_id);
    OrderedProduct orderedProductOriginal = this.cartService.findOrderedProduct(final_product_id, cartDB.getCart_id());
    OrderedProduct orderedProductCopy = new OrderedProduct();
    orderedProductCopy.setQuantity(orderedProductOriginal.getQuantity() * -1);
    orderedProductCopy.setFinalProduct(orderedProductOriginal.getFinalProduct());
    this.cartService.removeProduct(final_product_id, cartDB.getCart_id());
    List<OrderedProduct> orderedProductList = new ArrayList<>();
    orderedProductList.add(orderedProductCopy);
    this.finalProductService.reduceInventory(orderedProductList);
    saleDB.setTotal(cartDB.getTotal());
    saleDB.setItems(cartDB.getItems());
    saleDB.setStatus("Modificada");
    this.saleRepository.save(saleDB);
    return cartDB;
  }

  @Override
  public void cancelSale(Long sale_id) {
    Sale saleDB = this.saleRepository.findById(sale_id).get();
    Cart cartDB = this.cartService.findBySaleId(sale_id);
    List<OrderedProduct> orderedProductListDB = cartDB.getOrderedProductList();
    List<OrderedProduct> orderedProductListCopy = new ArrayList<>();
    for(OrderedProduct orderedProductDB: orderedProductListDB){
      OrderedProduct orderedProductCopy = new OrderedProduct();
      orderedProductCopy.setQuantity(orderedProductDB.getQuantity() * -1);
      orderedProductCopy.setFinalProduct(orderedProductDB.getFinalProduct());
      orderedProductListCopy.add(orderedProductCopy);
    }
    this.cartService.cleanCart(cartDB.getCart_id());
    this.finalProductService.reduceInventory(orderedProductListCopy);
    saleDB.setTotal(cartDB.getTotal());
    saleDB.setItems(cartDB.getItems());
    saleDB.setStatus("Anulada");
    this.saleRepository.save(saleDB);
  }

  @Override
  public Page<Sale> filter(Pageable pageable, Long user_id, Date startDate, Date endDate, Integer startTotal, Integer endTotal) {
    List<Sale> saleListDB = (List<Sale>) this.saleRepository.findAll();
    List<Sale> filtredByUser = new ArrayList<>();
    if(user_id > 0){
      for (Sale saleDB: saleListDB){
        if(Objects.equals(saleDB.getUser_id(), user_id)){
          filtredByUser.add(saleDB);
        }
      }
    }else {
      filtredByUser = saleListDB;
    }

    //Filtrando por total min y max
    List<Sale> filtredByTotal = new ArrayList<>();
    if(endTotal > 0){
      for(Sale saleDB: filtredByUser){
        if(saleDB.getTotal() != null) {
          if ((saleDB.getTotal() >= startTotal) && (saleDB.getTotal() <= endTotal)) {
            filtredByTotal.add(saleDB);
          }
        }
      }
    }else {
      filtredByTotal = filtredByUser;
    }

    //Filtrando por fecha...... por implementar.

    return this.convertListToPage(filtredByTotal, pageable);
  }


  public  Page<Sale> convertListToPage(List<Sale> list, Pageable pageable) {
    if (list == null || list.isEmpty()) {
      return new PageImpl<>(List.of(), pageable, 0);
    }

    int start = (int) pageable.getOffset();
    int end = Math.min((start + pageable.getPageSize()), list.size());

    if (start > end) {
      return new PageImpl<>(List.of(), pageable, list.size());
    }

    List<Sale> subList = list.subList(start, end);
    return new PageImpl<>(subList, pageable, list.size());
  }

}
