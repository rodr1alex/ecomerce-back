package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class CreateColorVariantProductDTO {
  @NotNull
  @Positive
  private Long colorId;
  private List<String> colorVariantProductImagesURL;
  @NotEmpty
  private List<@Valid CreateFinalProductDTO> finalProductList;

  // Getters y Setters
}
