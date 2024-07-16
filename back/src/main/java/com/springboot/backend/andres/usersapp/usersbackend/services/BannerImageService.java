package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.BannerImage;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IBannerImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerImageService implements IBannerImageService{
  @Autowired
  private IBannerImageRepository bannerImageRepository;

  @Override
  public List<BannerImage> getAll() {
    return (List<BannerImage>) this.bannerImageRepository.findAll();
  }
}
