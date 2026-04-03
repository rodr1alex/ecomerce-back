package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.Color;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.Size;
import lombok.Data;

@Data
public class SizesColors {
  private long finalProductId;
  private Size size;
  private Color color;
}
