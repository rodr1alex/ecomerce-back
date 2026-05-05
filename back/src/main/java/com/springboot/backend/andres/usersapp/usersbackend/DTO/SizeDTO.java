package com.springboot.backend.andres.usersapp.usersbackend.DTO;


import lombok.Data;

@Data
public class SizeDTO {
  private Long id;
  private String name;

  public SizeDTO(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public SizeDTO() {
  }
}
