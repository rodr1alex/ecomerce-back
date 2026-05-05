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
  public Page<BaseProduct> filter(Pageable pageable, Long brand_id, List<Long> categoryList);
  public List<Brand> getBrandList(List<Long> categoriesIds);
  public List<BaseProduct> findAllProductsCommerce();
  public BaseProduct getProductDetail(Long id);
  public Long createNew(CreateBaseProductDTO createBaseProductDTO);
}
