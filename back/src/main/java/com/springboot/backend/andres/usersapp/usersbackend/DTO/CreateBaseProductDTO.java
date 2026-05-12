package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@Setter
public class CreateBaseProductDTO {
  @NotBlank
  private String name;
  @NotNull
  @Positive
  private Integer basePrice;
  private String chars;
  private String specs;
  @NotNull
  @Positive
  private Long brandId;
  private List<String> baseProductImagesURL;
  @NotEmpty
  private List<@Valid CreateColorVariantProductDTO> colorVariantProductList;
  @NotEmpty
  private List<Long> categoriesId;

  // Getters y Setters
}
