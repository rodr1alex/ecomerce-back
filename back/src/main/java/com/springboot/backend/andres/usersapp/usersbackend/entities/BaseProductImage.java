package com.springboot.backend.andres.usersapp.usersbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "base_product_images")
public class BaseProductImage {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long base_product_image_id;
  private String url;
  @ManyToOne()
  @JoinColumn(name = "base_product_id", referencedColumnName = "base_product_id")
  @JsonIgnore
  private BaseProduct baseProduct;
}
