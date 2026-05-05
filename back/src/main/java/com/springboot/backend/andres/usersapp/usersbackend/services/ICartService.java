package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.CartForPaymentDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.OrderedProductDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.ProductReturned;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Cart;

import java.util.List;

public interface ICartService {
  public Cart createCart(CartForPaymentDTO cartDTO);
  public Cart saveCart(Cart cart);
  public Cart findById(Long cart_id);
  public List<Cart> findAll();
  public Cart modifyCart(Long cart_id, List<ProductReturned> productReturneds);


}
