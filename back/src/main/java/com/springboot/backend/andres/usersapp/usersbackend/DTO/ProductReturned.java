package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductReturned {
  @NotNull
  @Positive
  private Long finalProductId;
  @NotNull
  @Positive
  private Integer quantityToReturn;
}
