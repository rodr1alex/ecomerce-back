package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;

@Data
public class ColorDTO {
  private Long id;
  private String name;
  private String hexCodeColor;

  public ColorDTO(Long id, String name, String hexCodeColor) {
    this.id = id;
    this.name = name;
    this.hexCodeColor = hexCodeColor;
  }

  public ColorDTO() {
  }
}
