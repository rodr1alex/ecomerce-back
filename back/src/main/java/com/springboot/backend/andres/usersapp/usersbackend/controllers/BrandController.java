package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Brand;
import com.springboot.backend.andres.usersapp.usersbackend.services.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/brands")
public class BrandController {
  @Autowired
  private IBrandService brandService;

  @PostMapping("/create")
  public Brand createBrand(@RequestBody Brand brand){
    return this.brandService.createBrand(brand);
  }

  @GetMapping()
  public List<Brand> findAll(){
    return this.brandService.findAll();
  }

  @GetMapping("/{brand_id}")
  public Brand findById(@PathVariable Long brand_id){
    return this.brandService.findById(brand_id);
  }

  @PutMapping("/update/{brand_id}")
  public Brand updateBrand(@RequestBody Brand updatedBrand,@PathVariable Long brand_id){
    return this.brandService.updateBrand(updatedBrand, brand_id);
  }
}
