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
@Table(name = "brands")
public class Brand {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long brand_id;
  private String name;
  @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnore
  private List<BaseProduct> baseProductList;

}
