package com.springboot.backend.andres.usersapp.usersbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.internal.util.stereotypes.Lazy;

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
  @Column(name = "color_variant_product_image_id")
  private Long id;

  private String url;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "color_variant_product_id")
  private ColorVariantProduct colorVariantProduct;
}
