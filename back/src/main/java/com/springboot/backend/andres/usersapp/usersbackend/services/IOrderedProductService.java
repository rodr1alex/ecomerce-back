package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.OrderedProductDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.OrderedProduct;

public interface IOrderedProductService {
  public OrderedProduct createOrderedProduct(OrderedProductDTO newOrderedProduct, Long cart_id);
}
