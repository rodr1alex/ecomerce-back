package com.springboot.backend.andres.usersapp.usersbackend.services;


import com.springboot.backend.andres.usersapp.usersbackend.DTO.OrderedProductDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.ProductReturned;
import com.springboot.backend.andres.usersapp.usersbackend.entities.*;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IFinalProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FinalProductService implements IFinalProductService{
  @Autowired
  private IFinalProductRepository finalProductRepository;
  @Autowired
  private IBaseProductService baseProductService;


  @Override
  public FinalProduct findById(Long final_product_id) {
    return this.finalProductRepository.findById(final_product_id).get();
  }

  @Override
  public List<Long> verifyInventory(List<OrderedProductDTO> orderedProductList) {
    List<Long> final_products_no_stock = new ArrayList<>();
    for (OrderedProductDTO orderedProductDTO: orderedProductList){
      FinalProduct finalProductDB = this.findById(orderedProductDTO.getFinal_product_id());
      if(finalProductDB.getStock() < orderedProductDTO.getQuantity()){
        final_products_no_stock.add(finalProductDB.getFinal_product_id());
      }
    }
    return final_products_no_stock;
  }


  @Override
  public Page<FinalProduct> filter(Pageable pageable, Long brand_id, Long color_id, Long size_id, List<Long> categories) {
    if (categories != null && !categories.isEmpty()) {
      return finalProductRepository.filterAdvanced(brand_id, color_id, size_id, categories, (long) categories.size(), pageable);
    }

    return finalProductRepository.filterWithoutCategories(brand_id, color_id, size_id, pageable);
  }

  @Override
  public void removeFromInventory(List<OrderedProductDTO> orderedProducts) {
    for(OrderedProductDTO orderedProductDTO:  orderedProducts){
      FinalProduct finalProductDB = this.findById(orderedProductDTO.getFinal_product_id());
      finalProductDB.setStock(finalProductDB.getStock() - orderedProductDTO.getQuantity());
      this.finalProductRepository.save(finalProductDB);
    }
  }

  @Override
  public void addToInventory(List<ProductReturned> productReturners) {
    for (ProductReturned productReturned: productReturners){
      FinalProduct finalProductDB = this.findById(productReturned.getFinal_product_id());
      finalProductDB.setStock(finalProductDB.getStock() + productReturned.getQuantityToReturn());
      this.finalProductRepository.save(finalProductDB);
    }
  }


}
