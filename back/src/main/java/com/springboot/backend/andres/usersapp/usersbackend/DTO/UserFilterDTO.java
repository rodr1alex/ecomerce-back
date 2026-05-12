package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.Data;

@Data
public class UserFilterDTO {
  @Positive
  private Integer pageSize;
  @NotNull
  @Min(0)
  private Integer page;
  private Boolean admin;
}
