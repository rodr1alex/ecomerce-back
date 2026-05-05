package com.springboot.backend.andres.usersapp.usersbackend.DTO;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SaleFilterDTO {
  private Long userId;
  private Integer startTotal;
  private Integer endTotal;
  private Integer pageSize;
  private Integer page;
  private Long saleStatusId;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
}


