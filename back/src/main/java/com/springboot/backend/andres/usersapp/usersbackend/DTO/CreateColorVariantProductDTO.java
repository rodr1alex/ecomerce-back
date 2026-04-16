package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class CreateColorVariantProductDTO {
  private Long color_id;
  private List<String> colorVariantProductImagesURL;
  private List<CreateFinalProductDTO> finalProductList;

  // Getters y Setters
}
