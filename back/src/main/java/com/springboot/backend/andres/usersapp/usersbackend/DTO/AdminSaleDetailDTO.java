package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AdminSaleDetailDTO {
  private Long saleId;
  private LocalDateTime date;
  private DirectionDTO direction;
  private SaleStatusDTO saleStatus;
  private Integer total;
  private Integer items;
  private UserDTO user;
  private List<OrderedProductDetailDTO> products;

}
