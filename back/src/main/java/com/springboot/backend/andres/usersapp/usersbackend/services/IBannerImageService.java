package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.BannerImage;

import java.util.List;

public interface IBannerImageService {
  public List<BannerImage> getAll();
}
