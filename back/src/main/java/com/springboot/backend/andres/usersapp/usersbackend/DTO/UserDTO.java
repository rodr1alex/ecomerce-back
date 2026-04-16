package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Direction;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
  private Long id;

  @NotBlank
  private String name;

  @NotBlank
  private String lastname;

  @NotEmpty
  @Email
  private String email;

  @NotBlank
  @Size(min=4, max = 24)
  private String username;

  private boolean admin;

  private List<DirectionDTO> directionList;
}
