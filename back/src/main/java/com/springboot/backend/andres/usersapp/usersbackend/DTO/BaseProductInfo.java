package com.springboot.backend.andres.usersapp.usersbackend.DTO;

import lombok.*;

import java.util.List;


@Data
public class BaseProductInfo {
  private long baseProductId = 0;
  private String name;
  private double basePrice;
  private String brand;
  private List<GenericImage> imageList;
}
