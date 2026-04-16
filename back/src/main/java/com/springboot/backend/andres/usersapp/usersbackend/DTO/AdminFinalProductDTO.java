package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class AdminFinalProductDTO extends FinalProductDTO {
  private Integer stock; // Información confidencial
}
