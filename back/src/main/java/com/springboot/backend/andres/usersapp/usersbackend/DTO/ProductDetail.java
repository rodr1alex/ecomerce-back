package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDetail {
  private long baseProductId = 0;
  private String name;
  private double basePrice;
  private String brand;
  private String chars;
  private String specs;

  //OK
  // Main images for the base product
  private List<GenericImage> imageList = new ArrayList<>();

  // Combinations of Size and Color (e.g., Small/Red, Large/Blue)
  private List<SizesColors> sizesColorsAvailable = new ArrayList<>();

  //OK
  // Info for specific color groups (e.g., Red version has these 3 photos)
  private List<ColorVariantInfo> colorsVariantInfo = new ArrayList<>();
}
