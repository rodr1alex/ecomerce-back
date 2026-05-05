package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.ColorDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Color;
import com.springboot.backend.andres.usersapp.usersbackend.mappers.GeneralMapper;
import com.springboot.backend.andres.usersapp.usersbackend.services.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
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
  private Color create(@RequestBody Color color){
    return this.colorService.create(color);
  }

  //ok
  @GetMapping()
  private List<ColorDTO> findAll(){
    return this.colorService.findAll().stream().map(GeneralMapper::mapColorToColorDTO).toList();
  }

  //try remove
  @GetMapping("/{color_id}")
  private Color findById(@PathVariable Long color_id){
    return this.colorService.findById(color_id);
  }

  //try remove
  @PutMapping("/update/{color_id}")
  private Color update(@RequestBody Color color,@PathVariable Long color_id){
    return this.colorService.update(color, color_id);
  }

}
