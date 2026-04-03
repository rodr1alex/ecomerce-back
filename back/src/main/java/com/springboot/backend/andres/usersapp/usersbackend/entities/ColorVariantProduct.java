package com.springboot.backend.andres.usersapp.usersbackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "color_variant_products")
public class ColorVariantProduct {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long color_variant_product_id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "base_product_id")
  private BaseProduct baseProduct;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "color_id")
  private Color color;

  @OneToMany(mappedBy = "colorVariantProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<ColorVariantProductImage> colorVariantProductImageList;

  @OneToMany(mappedBy = "colorVariantProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<FinalProduct> finalProductList;



}
