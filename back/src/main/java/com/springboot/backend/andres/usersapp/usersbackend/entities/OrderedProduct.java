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
@Table(name = "ordered_products")
public class OrderedProduct {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long ordered_product_id;
  private Integer quantity;
  @ManyToOne()
  @JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
  @JsonIgnore
  private Cart cart;
  @ManyToOne()
  @JoinColumn(name = "final_product_id", referencedColumnName = "final_product_id")
  private FinalProduct finalProduct;

  @Override
  public String toString() {
    return "OrderedProduct{" +
      "ordered_product_id=" + ordered_product_id +
      ", quantity=" + quantity +
      ", cart=" + cart +
      ", finalProduct=" + finalProduct +
      '}';
  }
}
