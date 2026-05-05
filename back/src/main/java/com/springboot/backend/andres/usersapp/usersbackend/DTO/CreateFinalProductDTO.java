package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class CreateFinalProductDTO {
  private Integer stock;
  private Integer finalPrice;
  private Long sizeId;

  // Getters y Setters
}
