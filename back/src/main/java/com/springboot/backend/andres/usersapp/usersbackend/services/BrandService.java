package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Brand;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService implements IBrandService{
  @Autowired
  private IBrandRepository brandRepository;

  @Override
  public Brand createBrand(Brand brand) {
    return this.brandRepository.save(brand);
  }

  @Override
  public List<Brand> findAll() {
    return (List<Brand>) this.brandRepository.findAll();
  }

  @Override
  public Brand findById(Long brand_id) {
    return this.brandRepository.findById(brand_id).get();
  }

  @Override
  public Brand updateBrand(Brand updatedBrand, Long brand_id) {
    Brand brandDB = this.brandRepository.findById(brand_id).get();
    brandDB.setName(updatedBrand.getName());
    return this.brandRepository.save(brandDB);
  }

  @Override
  public void associateWithBaseProduct(Brand brand, BaseProduct baseProduct) {
    List<BaseProduct> baseProductListDB = brand.getBaseProductList();
    baseProductListDB.add(baseProduct);
    this.brandRepository.save(brand);
  }
}
