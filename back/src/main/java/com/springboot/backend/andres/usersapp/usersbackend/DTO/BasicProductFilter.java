package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;

import java.util.List;

@Data
public class BasicProductFilter {
  private Long brandId;
  private List<Long> categoriesIds;
  private Integer page;
  private Integer pageSize;
}


//brand_id: number | null;
//categoriesIds: number[] | null;
//page: number;
//pageSize: number;
