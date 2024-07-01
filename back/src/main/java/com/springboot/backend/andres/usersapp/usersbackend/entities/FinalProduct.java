package com.springboot.backend.andres.usersapp.usersbackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "final_products")
public class FinalProduct {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long final_product_id;
  private Integer stock;
  private Integer final_price;
  private String final_description;
  private String final_chars;
  private String final_specs;
  private String brand;
  private String color;
  private String img;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "color_variant_product_id", referencedColumnName = "color_variant_product_id")
  @JsonBackReference
  private ColorVariantProduct colorVariantProduct;
  @ManyToOne()
  @JoinColumn(name = "size_id", referencedColumnName = "size_id")
  private Size size;
  @OneToMany(mappedBy = "finalProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnore
  private List<OrderedProduct> orderedProductList;
}
