package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Cart;
import com.springboot.backend.andres.usersapp.usersbackend.entities.OrderedProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface ISaleService {
  public Sale findById(Long sale_id);
  public Page<Sale> findAll(Pageable pageable);
  public Sale createSale(Long cart_id, Long direction_id, Long user_id);
  public String modifySale(Long sale_id, List<OrderedProduct> orderedProductList);
 // public Cart returnProduct(OrderedProduct orderedProduct, Long sale_id);
 // public Cart removeProduct(Long final_product_id, Long sale_id);
 // public void cancelSale(Long sale_id);
  public Page<Sale> filter(Pageable pageable, Long user_id, Date startDate, Date endDate, Integer startTotal, Integer endTotal, String status);

}
