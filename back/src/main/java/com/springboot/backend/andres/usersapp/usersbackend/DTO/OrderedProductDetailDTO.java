package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;

@Data
public class OrderedProductDetailDTO {
  private Long ordered_product_id;
  private Long final_product_id;
  private Long base_product_id;
  private Integer quantity;
  private Integer originalQuantity;
  private String imgUrl;
  private String brand;
  private String productName;
  private String color;
  private String size;
  private Integer priceAtPurchase;

}
