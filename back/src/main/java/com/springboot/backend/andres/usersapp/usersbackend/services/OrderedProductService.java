package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.OrderedProductDTO;
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
  public OrderedProduct createOrderedProduct(OrderedProductDTO newOrderedProduct, Long cart_id) {
    OrderedProduct orderedProduct = new OrderedProduct();
    orderedProduct.setFinalProduct(this.finalProductService.findById(newOrderedProduct.getFinal_product_id()));
    orderedProduct.setQuantity(newOrderedProduct.getQuantity());
    orderedProduct.setPrice_at_purchase(orderedProduct.getFinalProduct().getFinal_price());
    orderedProduct.setCart(this.cartRepository.findById(cart_id).get());
    return this.orderedProductRepository.save(orderedProduct);
  }

}
