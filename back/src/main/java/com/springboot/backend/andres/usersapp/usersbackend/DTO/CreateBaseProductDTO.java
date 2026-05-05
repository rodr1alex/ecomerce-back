package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@Setter
public class CreateBaseProductDTO {
  private String name;
  private Integer basePrice;
  private String chars;
  private String specs;
  private Long brandId;
  private List<String> baseProductImagesURL;
  private List<CreateColorVariantProductDTO> colorVariantProductList;
  private List<Long> categoriesId;

  // Getters y Setters
}
