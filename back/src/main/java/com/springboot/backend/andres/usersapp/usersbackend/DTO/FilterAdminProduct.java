package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;

import java.util.List;

@Data
public class FilterAdminProduct {
  private Long brand_id;
  private Long color_id;
  private Long size_id;
  private Integer page;
  private Integer pageSize;
  private List<Long> categories;
}
