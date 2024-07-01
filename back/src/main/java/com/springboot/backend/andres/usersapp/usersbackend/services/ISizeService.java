package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Size;

import java.util.List;

public interface ISizeService {
  public Size create(Size size);
  public List<Size> findAll();
  public Size findById(Long size_id);
  public Size update(Size size, Long size_id);
}
