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
  @Column(name = "sale_id")
  private Long id;

  private LocalDateTime date;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "direction_id")
  private Direction direction;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "status_id")
  private SaleStatus status;

  @OneToOne(mappedBy = "sale", cascade = CascadeType.ALL)
  private Cart cart;

}
