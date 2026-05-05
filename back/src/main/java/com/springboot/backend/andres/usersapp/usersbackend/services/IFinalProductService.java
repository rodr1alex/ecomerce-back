package com.springboot.backend.andres.usersapp.usersbackend.services;


import com.springboot.backend.andres.usersapp.usersbackend.DTO.OrderedProductDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.ProductReturned;
import com.springboot.backend.andres.usersapp.usersbackend.entities.FinalProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFinalProductService {
  public FinalProduct findById(Long final_product_id);
  public List<Long> verifyInventory(List<OrderedProductDTO> orderedProductList);
  public Page<FinalProduct> filter(Pageable pageable, Long brand_id, Long color_id, Long size_id, List<Long> categories);
  public void removeFromInventory(List<OrderedProductDTO> orderedProducts);
  public void addToInventory(List<ProductReturned> productReturners);//addToInventory
}
