package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.OrderedProduct;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.ICartRepository;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IOrderedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderedProductService implements IOrderedProductService{
  @Autowired
  private IOrderedProductRepository orderedProductRepository;
  @Autowired
  private IFinalProductService finalProductService;
  @Autowired
  private ICartRepository cartRepository;

  @Override
  public OrderedProduct createOrderedProduct(OrderedProduct newOrderedProduct, Long cart_id) {
    OrderedProduct orderedProduct = new OrderedProduct();
    orderedProduct.setFinalProduct(this.finalProductService.findById(newOrderedProduct.getFinalProduct().getFinal_product_id()));
    orderedProduct.setQuantity(newOrderedProduct.getQuantity());
    orderedProduct.setCart(this.cartRepository.findById(cart_id).get());
    return this.orderedProductRepository.save(orderedProduct);
  }

  @Override
  public void removeOrderedProduct(Long ordered_product_id) {
      this.orderedProductRepository.deleteById(ordered_product_id);
  }

  @Override
  public OrderedProduct updateOrderedProduct(OrderedProduct updatedOrderedProduct, Long ordered_product_id) {
    OrderedProduct orderedProductDB = this.orderedProductRepository.findById(ordered_product_id).get();
    orderedProductDB.setQuantity(updatedOrderedProduct.getQuantity());
    return this.orderedProductRepository.save(orderedProductDB);
  }


}
