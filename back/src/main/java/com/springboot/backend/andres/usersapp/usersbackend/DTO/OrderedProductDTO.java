package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.Data;

@Data
public class OrderedProductDTO {
  @NotNull
  @Positive
  private Integer quantity;
  @NotNull
  @Positive
  private Long finalProductId;
}
