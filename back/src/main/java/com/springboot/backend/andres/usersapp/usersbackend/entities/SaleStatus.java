package com.springboot.backend.andres.usersapp.usersbackend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sale_statuses")
public class SaleStatus {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long status_id;

  private String name;

  private String description;

  @OneToMany(mappedBy = "status", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Sale> sales;
}
