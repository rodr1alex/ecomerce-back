package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProductImage;
import com.springboot.backend.andres.usersapp.usersbackend.entities.ColorVariantProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.ColorVariantProductImage;

import java.util.List;

public interface IColorVariantProductImageService {
  public List<ColorVariantProductImage> createWithList(List<ColorVariantProductImage> colorVariantProductImageList);
  public void associateWithColorVariantProduct(List<ColorVariantProductImage> colorVariantProductImageList, ColorVariantProduct colorVariantProduct);
  public ColorVariantProductImage create(ColorVariantProductImage colorVariantProductImage);
  public ColorVariantProductImage createAndAssociate(ColorVariantProductImage colorVariantProductImage, ColorVariantProduct colorVariantProduct);
  public void deleteById(Long id);
}
