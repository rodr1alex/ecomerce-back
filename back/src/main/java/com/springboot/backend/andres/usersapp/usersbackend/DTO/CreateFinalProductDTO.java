package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class CreateFinalProductDTO {
  @NotNull
  @PositiveOrZero
  private Integer stock;
  @NotNull
  @Positive
  private Integer finalPrice;
  @NotNull
  @Positive
  private Long sizeId;

  // Getters y Setters
}
