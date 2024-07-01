package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Cart;
import com.springboot.backend.andres.usersapp.usersbackend.entities.OrderedProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Sale;

public interface ISaleService {
  public Sale createSale(Long cart_id);
  public Cart returnProduct(OrderedProduct orderedProduct, Long sale_id);
  public Cart removeProduct(Long final_product_id, Long sale_id);
  public void cancelSale(Long sale_id);

}
