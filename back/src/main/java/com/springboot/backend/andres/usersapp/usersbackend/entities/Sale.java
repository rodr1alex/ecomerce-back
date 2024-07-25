package com.springboot.backend.andres.usersapp.usersbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long sale_id;
  private LocalDateTime date;
  private Long user_id;
  private Long cart_id;
  private String status;
  private String username;
  @ManyToOne()
  @JoinColumn(name = "direction_id", referencedColumnName = "direction_id")
  private Direction direction;

}
