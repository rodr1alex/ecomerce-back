package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Cart;
import com.springboot.backend.andres.usersapp.usersbackend.entities.OrderedProduct;

public interface ICartService {
  public Cart createCart(Long user_id);
  public Cart saveCart(Cart cart);
  public Cart findById(Long cart_id);
  public Cart addProduct(OrderedProduct orderedProduct, Long cart_id);
  public Cart removeProduct(Long final_product_id, Long cart_id);
  public Cart UpdateProductQuantity(OrderedProduct orderedProduct, Long cart_id);
  public Cart cleanCart(Long cart_id);
  public Cart findBySaleId(Long sale_id);
  public OrderedProduct findOrderedProduct(Long final_product_id, Long cart_id);
}
