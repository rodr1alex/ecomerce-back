package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Direction;
import com.springboot.backend.andres.usersapp.usersbackend.services.IDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/users/directions")
public class DirectionController {
  @Autowired
  private IDirectionService directionService;

  @PostMapping("/create/{id}")
  private Direction createDirection(@RequestBody Direction newDirection, @PathVariable Long id){
    return  this.directionService.createDirection(newDirection, id);
  }

  @PutMapping("/update/{direction_id}")
  private Direction updateDirection(@RequestBody Direction updatedDirection,@PathVariable Long direction_id){
    return this.directionService.updateDirection(updatedDirection, direction_id);
  }

  @DeleteMapping("/delete/{direction_id}")
  private void deleteDirection(@PathVariable Long direction_id){
    this.directionService.deleteDirection(direction_id);
  }

}
