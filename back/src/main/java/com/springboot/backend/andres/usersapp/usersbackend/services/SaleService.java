package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Cart;
import com.springboot.backend.andres.usersapp.usersbackend.entities.OrderedProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Sale;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService implements ISaleService{
  @Autowired
  private ISaleRepository saleRepository;
  @Autowired
  private ICartService cartService;
  @Autowired
  private IFinalProductService finalProductService;

  @Override
  public Sale createSale(Long cart_id) {
    Cart cartDB = this.cartService.findById(cart_id);
    Sale sale = new Sale();
    List<OrderedProduct> orderedProductListDB = cartDB.getOrderedProductList();
    this.finalProductService.reduceInventory(orderedProductListDB);
    sale.setDate(LocalDateTime.now());
    sale = this.saleRepository.save(sale);
    cartDB.setSale(sale);
    this.cartService.saveCart(cartDB);
    return sale;
  }

  @Override
  public Cart returnProduct(OrderedProduct orderedProduct, Long sale_id) {
    Cart cartDB = this.cartService.findBySaleId(sale_id);
    OrderedProduct orderedProductOriginal = this.cartService.findOrderedProduct(orderedProduct.getFinalProduct().getFinal_product_id(), cartDB.getCart_id());
    Integer differential =orderedProduct.getQuantity() - orderedProductOriginal.getQuantity();
    this.cartService.UpdateProductQuantity(orderedProduct,cartDB.getCart_id());
    orderedProduct.setQuantity(differential);
    List<OrderedProduct> orderedProductList = new ArrayList<>();
    orderedProductList.add(orderedProduct);
    this.finalProductService.reduceInventory(orderedProductList);
    return cartDB;
  }

  @Override
  public Cart removeProduct(Long final_product_id, Long sale_id) {
    Cart cartDB = this.cartService.findBySaleId(sale_id);
    OrderedProduct orderedProductOriginal = this.cartService.findOrderedProduct(final_product_id, cartDB.getCart_id());
    OrderedProduct orderedProductCopy = new OrderedProduct();
    orderedProductCopy.setQuantity(orderedProductOriginal.getQuantity() * -1);
    orderedProductCopy.setFinalProduct(orderedProductOriginal.getFinalProduct());
    this.cartService.removeProduct(final_product_id, cartDB.getCart_id());
    List<OrderedProduct> orderedProductList = new ArrayList<>();
    orderedProductList.add(orderedProductCopy);
    this.finalProductService.reduceInventory(orderedProductList);
    return cartDB;
  }

  @Override
  public void cancelSale(Long sale_id) {
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
  }
}
