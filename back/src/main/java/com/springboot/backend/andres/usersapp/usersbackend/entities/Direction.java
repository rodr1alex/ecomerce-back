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
@Table(name = "directions")
public class Direction {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "direction_id")
  private Long id;

  @NotBlank
  private String city;

  @NotBlank
  private String street;

  @NotBlank
  private String number;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(mappedBy = "direction", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Sale> saleList;

}
