package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Category;
import com.springboot.backend.andres.usersapp.usersbackend.entities.FinalProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.OrderedProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFinalProductService {
  public FinalProduct create(FinalProduct finalProduct);
  public Page<FinalProduct> findAll(Pageable pageable);
  public FinalProduct findById(Long final_product_id);
  public FinalProduct update(FinalProduct finalProduct, Long final_product_id);
  public List<FinalProduct> verifyInventory(List<OrderedProduct> orderedProductList);
  public void reduceInventory(List<OrderedProduct> orderedProductList);
  public Page<FinalProduct> filter(Pageable pageable, Long brand_id, Long color_id, Long size_id, List<Category> categoryList);
}
