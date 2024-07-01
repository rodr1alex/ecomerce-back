package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Size;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.ISizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService implements ISizeService {
  @Autowired
  private ISizeRepository sizeRepository;

  @Override
  public Size create(Size size) {
    return this.sizeRepository.save(size);
  }

  @Override
  public List<Size> findAll() {
    return (List<Size>) this.sizeRepository.findAll();
  }

  @Override
  public Size findById(Long size_id) {
    return this.sizeRepository.findById(size_id).get();
  }

  @Override
  public Size update(Size size, Long size_id) {
    Size sizeDB = this.sizeRepository.findById(size_id).get();
    sizeDB.setName(size.getName());
    return this.sizeRepository.save(sizeDB);
  }
}
