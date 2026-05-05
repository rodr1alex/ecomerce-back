package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;

import java.util.List;

@Data
public class CartForPaymentDTO {
  private Long userId;
  private Long directionId;
  private List<OrderedProductDTO> products;
}
