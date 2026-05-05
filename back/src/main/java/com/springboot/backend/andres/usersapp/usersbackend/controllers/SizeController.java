package com.springboot.backend.andres.usersapp.usersbackend.controllers;


import com.springboot.backend.andres.usersapp.usersbackend.DTO.SizeDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Size;
import com.springboot.backend.andres.usersapp.usersbackend.mappers.GeneralMapper;
import com.springboot.backend.andres.usersapp.usersbackend.services.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
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
  public Size create(@RequestBody Size size){
    return this.sizeService.create(size);
  }

  //ok
  @GetMapping()
  public List<SizeDTO> findAll(){
    return this.sizeService.findAll().stream().map(GeneralMapper::mapSizeToSizeDTO).toList();
  }

  //try remove
  @GetMapping("/{size_id}")
  public Size findById(@PathVariable Long size_id){
    return this.sizeService.findById(size_id);
  }

  //try remove
  @PutMapping("/update/{size_id}")
  public Size update(@RequestBody Size size,@PathVariable Long size_id){
    return this.sizeService.update(size, size_id);
  }
}
