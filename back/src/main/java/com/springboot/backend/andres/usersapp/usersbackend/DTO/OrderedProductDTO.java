package com.springboot.backend.andres.usersapp.usersbackend.DTO;


import lombok.Data;

@Data
public class OrderedProductDTO {
  private Integer quantity;
  private Long final_product_id;
}
