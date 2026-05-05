package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminFinalProductDTO  {
  private Long final_product_id;
  private Integer final_price;
  private String color;
  private String size;
  private String brand;
  private String name;
  private Long base_product_id;
  private Integer stock; // Información confidencial

}
