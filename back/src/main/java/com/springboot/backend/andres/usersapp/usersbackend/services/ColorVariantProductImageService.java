package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.ColorVariantProductImage;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IColorVariantProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorVariantProductImageService implements IColorVariantProductImageService{
  @Autowired
  private IColorVariantProductImageRepository colorVariantProductImageRepository;


  @Override
  public ColorVariantProductImage create(ColorVariantProductImage colorVariantProductImage) {
    return this.colorVariantProductImageRepository.save(colorVariantProductImage);
  }

}
