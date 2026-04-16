package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;

@Data
public class BrandDTO {
  private Long brand_id;
  private String name;

  public BrandDTO(Long brand_id, String name) {
    this.brand_id = brand_id;
    this.name = name;
  }
}
