package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;

import java.util.List;

@Data
public class FilterAdminProduct {
  private Long brandId;
  private Long colorId;
  private Long sizeId;
  private Integer page;
  private Integer pageSize;
  private List<Long> categories;
}
