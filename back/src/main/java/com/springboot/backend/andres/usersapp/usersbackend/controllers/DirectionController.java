package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.DirectionDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Direction;
import com.springboot.backend.andres.usersapp.usersbackend.mappers.DirectionMapper;
import com.springboot.backend.andres.usersapp.usersbackend.services.IDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/users/directions")
public class DirectionController {
  @Autowired
  private IDirectionService directionService;

  @GetMapping("/getByUser/{user_id}")
  private List<DirectionDTO> getDirectionsByUser(@PathVariable Long user_id){
    return  this.directionService.getDirectionsByUser(user_id);
  }

  @PostMapping("/create/{id}")
  private DirectionDTO createDirection(@RequestBody Direction newDirection, @PathVariable Long id){
    return  DirectionMapper.mapDirectionToDirectioDTO(this.directionService.createDirection(newDirection, id));
  }

  @PutMapping("/update/{direction_id}")
  private DirectionDTO updateDirection(@RequestBody Direction updatedDirection,@PathVariable Long direction_id){
    return DirectionMapper.mapDirectionToDirectioDTO(this.directionService.updateDirection(updatedDirection, direction_id));
  }

  @DeleteMapping("/delete/{direction_id}")
  private void deleteDirection(@PathVariable Long direction_id){
    this.directionService.deleteDirection(direction_id);
  }

}
