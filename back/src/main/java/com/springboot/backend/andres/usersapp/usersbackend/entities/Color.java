package com.springboot.backend.andres.usersapp.usersbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "colors")
public class Color {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "color_id")
  private Long id;

  @NotBlank
  private String name;

  @Column(name = "tailwindclass")
  private String tailwindClass;

  private String hexCodeColor;

  @OneToMany(mappedBy = "color", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<ColorVariantProduct> colorVariantProductList;
}
