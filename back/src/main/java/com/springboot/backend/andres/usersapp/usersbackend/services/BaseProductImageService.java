package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProductImage;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IBaseProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseProductImageService implements IBaseProductImageService{
  @Autowired
  private IBaseProductImageRepository baseProductImageRepository;



  @Override
  public List<BaseProductImage> createWithList(List<BaseProductImage> baseProductImageList) {
    List<BaseProductImage> baseProductImageListDB = new ArrayList<>();
    for (BaseProductImage baseProductImage: baseProductImageList){
      BaseProductImage baseProductImageDB = this.baseProductImageRepository.save(baseProductImage);
      baseProductImageListDB.add(baseProductImageDB);
    }
    return baseProductImageListDB;
  }

  @Override
  public void associateWithBaseProduct(List<BaseProductImage> baseProductImageList, BaseProduct baseProduct) {
    for(BaseProductImage baseProductImage: baseProductImageList){
      baseProductImage.setBaseProduct(baseProduct);
      this.baseProductImageRepository.save(baseProductImage);
    }
  }

  @Override
  public BaseProductImage create(BaseProductImage baseProductImage) {
    return this.baseProductImageRepository.save(baseProductImage);
  }

  @Override
  public BaseProductImage createAndAssociate(BaseProductImage baseProductImage, BaseProduct baseProduct) {
    baseProductImage.setBaseProduct(baseProduct);
    return this.baseProductImageRepository.save(baseProductImage);
  }

  @Override
  public void delete(Long id) {
      this.baseProductImageRepository.deleteById(id);
  }


}
