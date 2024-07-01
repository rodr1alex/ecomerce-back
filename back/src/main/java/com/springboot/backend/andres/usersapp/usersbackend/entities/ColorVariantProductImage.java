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
@Table(name = "color_variant_product_images")
public class ColorVariantProductImage {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long color_variant_product_image_id;
  private String url;
  @ManyToOne()
  @JoinColumn(name = "color_variant_product_id", referencedColumnName = "color_variant_product_id")
  @JsonIgnore
  private ColorVariantProduct colorVariantProduct;
}
