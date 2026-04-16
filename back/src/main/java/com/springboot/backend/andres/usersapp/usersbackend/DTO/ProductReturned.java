package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;

@Data
public class ProductReturned {
  private Long final_product_id;
  private Long ordered_product_id;
  private Integer quantityToReturn;
}
