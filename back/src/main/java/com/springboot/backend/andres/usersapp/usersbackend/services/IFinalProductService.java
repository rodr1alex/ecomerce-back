package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.FinalProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.OrderedProduct;

import java.util.List;

public interface IFinalProductService {
  public FinalProduct create(FinalProduct finalProduct);
  public FinalProduct findById(Long final_product_id);
  public FinalProduct update(FinalProduct finalProduct, Long final_product_id);
  public List<FinalProduct> verifyInventory(List<OrderedProduct> orderedProductList);
  public void reduceInventory(List<OrderedProduct> orderedProductList);
}
