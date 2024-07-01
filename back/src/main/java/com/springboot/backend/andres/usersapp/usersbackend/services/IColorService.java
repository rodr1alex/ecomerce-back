package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Color;

import java.util.List;

public interface IColorService {
  public Color create(Color color);
  public List<Color> findAll();
  public Color findById(Long color_id);
  public Color update(Color color, Long color_id);
}
