package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;

import java.util.List;

@Data
public class ColorVariantInfo {
  private Color color;
  private List<GenericImage> imageList;
}
