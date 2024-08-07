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
  private String img;
  private Long base_product_id;
  private String name;  // al actualizar base_product
  private String brand; // al actualizar base_product
  private String color; //, al actualizar color_variant_product
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
