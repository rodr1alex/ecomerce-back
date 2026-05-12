package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SaleFilterDTO {
  private Long userId;
  private Integer startTotal;
  private Integer endTotal;
  @Positive
  private Integer pageSize;
  @NotNull
  @Min(0)
  private Integer page;
  private Long saleStatusId;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
}


