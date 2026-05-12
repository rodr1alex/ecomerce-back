package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Data
public class BasicProductFilter {
  private Long brandId;
  private List<Long> categoriesIds;
  @NotNull
  @Min(0)
  private Integer page;
  @NotNull
  @Positive
  private Integer pageSize;
}


//brand_id: number | null;
//categoriesIds: number[] | null;
//page: number;
//pageSize: number;
