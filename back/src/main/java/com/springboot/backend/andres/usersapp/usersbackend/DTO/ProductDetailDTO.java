package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDetailDTO {
  private Long baseProductId;
  private String name;
  private double basePrice;
  private String brand;
  private String chars;
  private String specs;
  private List<GenericImage> imageList = new ArrayList<>();
  private List<SizesColors> sizesColorsAvailable = new ArrayList<>();
  private List<ColorVariantInfo> colorsVariantInfo = new ArrayList<>();
}
