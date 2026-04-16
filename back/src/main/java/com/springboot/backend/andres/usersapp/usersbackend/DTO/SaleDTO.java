package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import com.springboot.backend.andres.usersapp.usersbackend.entities.SaleStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SaleDTO {
  private Long sale_id;
  private LocalDateTime date;
  private DirectionDTO direction;
  private SaleStatusDTO saleStatus;
  private CartDTO cart;
  private Integer total;
  private Integer items;
  private UserDTO user;
}
