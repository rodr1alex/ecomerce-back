package com.springboot.backend.andres.usersapp.usersbackend.DTO;


import lombok.Data;

@Data
public class DirectionDTO {
  private Long direction_id;
  private String city;
  private String street;
  private String number;
}
