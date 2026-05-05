package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminSaleBasicInfoDTO {
  private Long saleId;
  private LocalDateTime date;
  private Integer total;
  private Integer items;
  private UserDTO user;
  private SaleStatusDTO saleStatus;
}
