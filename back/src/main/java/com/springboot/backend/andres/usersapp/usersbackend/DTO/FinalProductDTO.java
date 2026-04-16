package com.springboot.backend.andres.usersapp.usersbackend.DTO;


import lombok.Data;

@Data
public class FinalProductDTO {
  private Long final_product_id;
  private Integer final_price;
  private String color;
  private String size;
  private String brand;
  private String name;
}
