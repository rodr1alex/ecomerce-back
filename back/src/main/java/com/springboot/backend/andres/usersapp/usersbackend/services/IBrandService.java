package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Brand;

import java.util.List;

public interface IBrandService {
  public Brand createBrand(Brand brand);
  public List<Brand> findAll();
  public Brand findById(Long brand_id);
  public Brand updateBrand(Brand brand, Long brand_id);
  public void associateWithBaseProduct(Brand brand, BaseProduct baseProduct);
}
