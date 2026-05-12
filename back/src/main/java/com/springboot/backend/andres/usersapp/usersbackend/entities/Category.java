package com.springboot.backend.andres.usersapp.usersbackend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "category_id")
  private Long id;

  @NotBlank
  private String name;

  @ManyToMany(mappedBy = "categoryList")
  private Set<BaseProduct> baseProductList = new HashSet<>();

}
