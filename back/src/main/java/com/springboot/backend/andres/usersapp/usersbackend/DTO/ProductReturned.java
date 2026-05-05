package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductReturned {
  private Long finalProductId;
  private Integer quantityToReturn;
}
