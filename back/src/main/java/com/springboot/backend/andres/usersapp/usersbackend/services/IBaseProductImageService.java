package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProductImage;

import java.util.List;

public interface IBaseProductImageService {
  public List<BaseProductImage> createWithList(List<BaseProductImage> baseProductImageList);
  public void associateWithBaseProduct(List<BaseProductImage> baseProductImageList, BaseProduct baseProduct);
  public BaseProductImage create(BaseProductImage baseProductImage);
  public BaseProductImage createAndAssociate(BaseProductImage baseProductImage, BaseProduct baseProduct);
  public void delete(Long id);
}
