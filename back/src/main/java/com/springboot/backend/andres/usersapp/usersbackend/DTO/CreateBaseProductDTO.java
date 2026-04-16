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
  private Integer base_price;
  private String chars;
  private String specs;
  private Long brand_id;
  private List<String> baseProductImagesURL;
  private List<CreateColorVariantProductDTO> colorVariantProductList;
  private List<Long> categories_id;

  // Getters y Setters
}
