package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;

@Data
public class BrandDTO {
  private Long id;
  private String name;

  public BrandDTO(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
