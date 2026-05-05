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
  @Column(name = "final_product_id")
  private Long id;

  private Integer stock;

  private Integer finalPrice;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "color_variant_product_id")
  private ColorVariantProduct colorVariantProduct;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "size_id")
  private Size size;

  private String img;

  @OneToMany(mappedBy = "finalProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<OrderedProduct> orderedProductList;
}
