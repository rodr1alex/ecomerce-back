package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.ColorVariantProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.ColorVariantProductImage;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IColorVariantProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorVariantProductImageService implements IColorVariantProductImageService{
  @Autowired
  private IColorVariantProductImageRepository colorVariantProductImageRepository;

  @Override
  public List<ColorVariantProductImage> createWithList(List<ColorVariantProductImage> colorVariantProductImageList) {
    List<ColorVariantProductImage> colorVariantProductImageListDB = new ArrayList<>();
    for(ColorVariantProductImage colorVariantProductImage: colorVariantProductImageList){
      ColorVariantProductImage colorVariantProductImageDB = this.colorVariantProductImageRepository.save(colorVariantProductImage);
      colorVariantProductImageListDB.add(colorVariantProductImageDB);
    }
    return colorVariantProductImageListDB;
  }

  @Override
  public void associateWithColorVariantProduct(List<ColorVariantProductImage> colorVariantProductImageList, ColorVariantProduct colorVariantProduct) {
    for(ColorVariantProductImage colorVariantProductImageDB: colorVariantProductImageList){
      colorVariantProductImageDB.setColorVariantProduct(colorVariantProduct);
      this.colorVariantProductImageRepository.save(colorVariantProductImageDB);
    }
  }

  @Override
  public ColorVariantProductImage create(ColorVariantProductImage colorVariantProductImage) {
    return this.colorVariantProductImageRepository.save(colorVariantProductImage);
  }

  @Override
  public ColorVariantProductImage createAndAssociate(ColorVariantProductImage colorVariantProductImage, ColorVariantProduct colorVariantProduct) {
    colorVariantProductImage.setColorVariantProduct(colorVariantProduct);
    return this.colorVariantProductImageRepository.save(colorVariantProductImage);
  }

  @Override
  public void deleteById(Long id) {
    this.colorVariantProductImageRepository.deleteById(id);
  }
}
