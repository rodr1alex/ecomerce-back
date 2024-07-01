package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Color;
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

  @PostMapping("/create")
  private Color create(@RequestBody Color color){
    return this.colorService.create(color);
  }

  @GetMapping()
  private List<Color> findAll(){
    return this.colorService.findAll();
  }

  @GetMapping("/{color_id}")
  private Color findById(@PathVariable Long color_id){
    return this.colorService.findById(color_id);
  }

  @PutMapping("/update/{color_id}")
  private Color update(@RequestBody Color color,@PathVariable Long color_id){
    return this.colorService.update(color, color_id);
  }

}
