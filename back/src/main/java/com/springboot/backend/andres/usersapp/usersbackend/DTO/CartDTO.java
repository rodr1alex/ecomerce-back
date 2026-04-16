package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;

import java.util.List;

@Data
public class CartDTO {
  private Long user_id;
  private Long direction_id;
  private List<OrderedProductDTO> products;
}
