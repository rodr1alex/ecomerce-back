package com.springboot.backend.andres.usersapp.usersbackend.controllers;


import com.springboot.backend.andres.usersapp.usersbackend.DTO.SizeDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Size;
import com.springboot.backend.andres.usersapp.usersbackend.mappers.GeneralMapper;
import com.springboot.backend.andres.usersapp.usersbackend.services.ISizeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/sizes")
public class SizeController {
  @Autowired
  private ISizeService sizeService;

  //try remove
  @PostMapping("/create")
  public ResponseEntity<Size> create(@Valid @RequestBody Size size){
    return ResponseEntity.status(HttpStatus.CREATED).body(this.sizeService.create(size));
  }

  //ok
  @GetMapping()
  public ResponseEntity<List<SizeDTO>> findAll(){
    return ResponseEntity.ok(this.sizeService.findAll().stream().map(GeneralMapper::mapSizeToSizeDTO).toList());
  }

  //try remove
  @GetMapping("/{size_id}")
  public ResponseEntity<Size> findById(@PathVariable Long size_id){
    return ResponseEntity.ok(this.sizeService.findById(size_id));
  }

  //try remove
  @PutMapping("/update/{size_id}")
  public ResponseEntity<Size> update(@Valid @RequestBody Size size,@PathVariable Long size_id){
    return ResponseEntity.ok(this.sizeService.update(size, size_id));
  }
}
