package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.BrandDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Brand;
import com.springboot.backend.andres.usersapp.usersbackend.mappers.GeneralMapper;
import com.springboot.backend.andres.usersapp.usersbackend.services.IBrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/brands")
public class BrandController {
  @Autowired
  private IBrandService brandService;

  //try remove
  @PostMapping("/create")
  public ResponseEntity<Brand> createBrand(@Valid @RequestBody Brand brand){
    return ResponseEntity.status(HttpStatus.CREATED).body(this.brandService.createBrand(brand));
  }

  //ok
  @GetMapping()
  public ResponseEntity<List<BrandDTO>> findAll(){
    return ResponseEntity.ok(this.brandService.findAll().stream().map(GeneralMapper::mapBrandToBrandDTO).toList());
  }

  //try remove
  @GetMapping("/{brand_id}")
  public ResponseEntity<Brand> findById(@PathVariable Long brand_id){
    return ResponseEntity.ok(this.brandService.findById(brand_id));
  }

  //try remove
  @PutMapping("/update/{brand_id}")
  public ResponseEntity<Brand> updateBrand(@Valid @RequestBody Brand updatedBrand,@PathVariable Long brand_id){
    return ResponseEntity.ok(this.brandService.updateBrand(updatedBrand, brand_id));
  }
}
