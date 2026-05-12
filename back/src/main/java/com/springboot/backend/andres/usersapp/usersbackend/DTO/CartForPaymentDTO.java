package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Data
public class CartForPaymentDTO {
  @NotNull
  @Positive
  private Long userId;
  @NotNull
  @Positive
  private Long directionId;
  @NotEmpty
  private List<@Valid OrderedProductDTO> products;
}
