package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Color;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService implements IColorService{
  @Autowired
  private IColorRepository colorRepository;

  @Override
  public Color create(Color color) {
    return this.colorRepository.save(color);
  }

  @Override
  public List<Color> findAll() {
    return (List<Color>) this.colorRepository.findAll();
  }

  @Override
  public Color findById(Long color_id) {
    return this.colorRepository.findById(color_id).get();
  }

  @Override
  public Color update(Color color, Long color_id) {
    Color colorDB = this.colorRepository.findById(color_id).get();
    colorDB.setName(color.getName());
    colorDB.setTailwindclass(color.getTailwindclass());
    return this.colorRepository.save(colorDB);
  }
}
