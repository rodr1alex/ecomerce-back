package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.Data;

@Data
public class OrderedProductDetailDTO {
  private Long orderedProductId;
  private Long finalProductId;
  private Long baseProductId;
  private Integer quantity;
  private Integer originalQuantity;
  private String imgUrl;
  private String brand;
  private String productName;
  private String color;
  private String size;
  private Integer priceAtPurchase;

}
