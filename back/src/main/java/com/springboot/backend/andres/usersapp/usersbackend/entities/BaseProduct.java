package com.springboot.backend.andres.usersapp.usersbackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "base_products")
public class BaseProduct {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long base_product_id;
  private String name;
  private Integer base_price;
  private String description;
  private String chars;
  private String specs;
  @ManyToOne()
  @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
  private Brand brand;
  @OneToMany(mappedBy = "baseProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<BaseProductImage> baseProductImageList;
  @OneToMany(mappedBy = "baseProduct", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<ColorVariantProduct> colorVariantProductList;
  @JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
    name="base_products_categories",
    joinColumns = {@JoinColumn(name="base_product_id")},
    inverseJoinColumns = @JoinColumn(name="category_id"),
    uniqueConstraints = { @UniqueConstraint(columnNames = {"base_product_id", "category_id"})}
  )
  private List<Category> categoryList;

}
