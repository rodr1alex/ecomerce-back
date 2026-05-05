package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProductImage;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IBaseProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BaseProductImageService implements IBaseProductImageService{
  @Autowired
  private IBaseProductImageRepository baseProductImageRepository;

  @Override
  public BaseProductImage create(BaseProductImage baseProductImage) {
    return this.baseProductImageRepository.save(baseProductImage);
  }


}
