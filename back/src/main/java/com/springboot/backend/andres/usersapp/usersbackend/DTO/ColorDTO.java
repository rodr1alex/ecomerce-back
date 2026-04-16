package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;

@Data
public class ColorDTO {
  private Long color_id;
  private String name;
  private String hex_code_color;

  public ColorDTO(Long color_id, String name, String hex_code_color) {
    this.color_id = color_id;
    this.name = name;
    this.hex_code_color = hex_code_color;
  }

  public ColorDTO() {
  }
}
