package com.springboot.backend.andres.usersapp.usersbackend.DTO;


import lombok.Data;

@Data
public class UserFilterDTO {
  private Integer page_size;
  private Integer page;
  private Boolean admin;
}
