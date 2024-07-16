package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import com.springboot.backend.andres.usersapp.usersbackend.entities.BannerImage;
import com.springboot.backend.andres.usersapp.usersbackend.services.IBannerImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/banner_images")
public class BannerImageController {
  @Autowired
  private IBannerImageService bannerImageService;

  @GetMapping("")
  public List<BannerImage> findAll(){
    return this.bannerImageService.getAll();
  }
}
