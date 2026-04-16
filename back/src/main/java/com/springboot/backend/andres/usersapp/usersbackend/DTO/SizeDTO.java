package com.springboot.backend.andres.usersapp.usersbackend.DTO;


import lombok.Data;

@Data
public class SizeDTO {
  private Long size_id;
  private String name;

  public SizeDTO(Long size_id, String name) {
    this.size_id = size_id;
    this.name = name;
  }

  public SizeDTO() {
  }
}
