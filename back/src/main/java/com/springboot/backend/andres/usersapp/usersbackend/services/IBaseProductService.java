package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBaseProductService {
  public BaseProduct create(BaseProduct newBaseProduct);
  public BaseProduct findById(Long base_product_id);
  public Page<BaseProduct> getFeaturedProducts(Pageable pageable);
  public BaseProduct update(BaseProduct updatedBaseProduct, Long base_product_id);
  public BaseProduct addImage(BaseProductImage baseProductImage, Long base_product_id);
  public BaseProduct removeImage(BaseProductImage baseProductImage, Long base_product_id);
  public Page<BaseProduct> filterByBrand(Long brand_id, Pageable pageable, List<Category> categoryList);
  public Page<BaseProduct> filterByCategoryList(List<Category> categoryList, Pageable pageable);
  public List<Brand> getBrandList(List<Category> categoryList);
  public List<FinalProduct>  filterByBrandAndCategoryListAndColorAndSize(Long brand_id, Long color_id, Long size_id, List<Category> categoryList);
  //public void associateWithColorVariantProduct(BaseProduct baseProduct, ColorVariantProduct colorVariantProduct);
}
