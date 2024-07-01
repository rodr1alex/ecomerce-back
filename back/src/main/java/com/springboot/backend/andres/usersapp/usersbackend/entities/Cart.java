package com.springboot.backend.andres.usersapp.usersbackend.entities;


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
@Table(name = "carts")
public class Cart {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long cart_id;
  private Integer total;
  private Integer items;
  @ManyToOne()
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  @JsonIgnore
  private User user;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "sale_id", referencedColumnName = "sale_id")
  private Sale sale;
  @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<OrderedProduct> orderedProductList;

}
