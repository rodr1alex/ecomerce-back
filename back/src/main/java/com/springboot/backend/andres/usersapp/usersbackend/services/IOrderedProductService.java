package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.OrderedProduct;

public interface IOrderedProductService {
  public OrderedProduct createOrderedProduct(OrderedProduct newOrderedProduct, Long cart_id);
  public void removeOrderedProduct(Long ordered_product_id);
  public OrderedProduct updateOrderedProduct(OrderedProduct updatedOrderedProduct, Long ordered_product_id);
}
