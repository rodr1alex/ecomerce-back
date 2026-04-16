package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.BasicProductInfoDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.BrandDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.CreateBaseProductDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.ProductDetailDTO;
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
  public Page<BasicProductInfoDTO> filterByBrand(Long brand_id, Pageable pageable, List<Category> categoryList);
  public Page<BasicProductInfoDTO> filterByCategoryList(List<Long> categoriesIds, Pageable pageable);
  public List<BrandDTO> getBrandList(List<Long> categoriesIds);
  public List<FinalProduct>  filterByBrandAndCategoryListAndColorAndSize(Long brand_id, Long color_id, Long size_id, List<Long> categories);
  //public void associateWithColorVariantProduct(BaseProduct baseProduct, ColorVariantProduct colorVariantProduct);

  public  List<BasicProductInfoDTO> findAllProductsCommerce();
  public ProductDetailDTO getProductDetail(Long id);

  public Long createNew(CreateBaseProductDTO createBaseProductDTO);
}
