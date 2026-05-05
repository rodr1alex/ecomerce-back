package com.springboot.backend.andres.usersapp.usersbackend.entities;

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
@Table(name = "banner_images")
public class BannerImage {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "banner_image_id")
  private Long id;
  private String url;
  private boolean mobile;
}
