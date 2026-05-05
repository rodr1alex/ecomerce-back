package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;

import java.util.List;

@Data
public class CartForPaymentDTO {
  private Long user_id;
  private Long direction_id;
  private List<OrderedProductDTO> products;
}
