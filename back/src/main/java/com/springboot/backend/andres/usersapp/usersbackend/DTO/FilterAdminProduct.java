package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Data
public class FilterAdminProduct {
  private Long brandId;
  private Long colorId;
  private Long sizeId;
  @NotNull
  @Min(0)
  private Integer page;
  @NotNull
  @Positive
  private Integer pageSize;
  private List<Long> categories;
}
