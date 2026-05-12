package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.ColorDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Color;
import com.springboot.backend.andres.usersapp.usersbackend.mappers.GeneralMapper;
import com.springboot.backend.andres.usersapp.usersbackend.services.IColorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/colors")
public class ColorController {
  @Autowired
  private IColorService colorService;

  //try remove
  @PostMapping("/create")
  public ResponseEntity<Color> create(@Valid @RequestBody Color color){
    return ResponseEntity.status(HttpStatus.CREATED).body(this.colorService.create(color));
  }

  //ok
  @GetMapping()
  public ResponseEntity<List<ColorDTO>> findAll(){
    return ResponseEntity.ok(this.colorService.findAll().stream().map(GeneralMapper::mapColorToColorDTO).toList());
  }

  //try remove
  @GetMapping("/{color_id}")
  public ResponseEntity<Color> findById(@PathVariable Long color_id){
    return ResponseEntity.ok(this.colorService.findById(color_id));
  }

  //try remove
  @PutMapping("/update/{color_id}")
  public ResponseEntity<Color> update(@Valid @RequestBody Color color,@PathVariable Long color_id){
    return ResponseEntity.ok(this.colorService.update(color, color_id));
  }

}
