package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.DirectionDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Direction;
import com.springboot.backend.andres.usersapp.usersbackend.mappers.DirectionMapper;
import com.springboot.backend.andres.usersapp.usersbackend.services.IDirectionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/users/directions")
public class DirectionController {
  @Autowired
  private IDirectionService directionService;

  //ok
  @GetMapping("/getByUser/{user_id}")
  public ResponseEntity<List<DirectionDTO>> getDirectionsByUser(@PathVariable Long user_id){
    return ResponseEntity.ok(this.directionService.getDirectionsByUser(user_id).stream().map(DirectionMapper::mapDirectionToDirectionDTO).toList());
  }

  //ok
  @PostMapping("/create/{id}")
  public ResponseEntity<DirectionDTO> createDirection(@Valid @RequestBody Direction newDirection, @PathVariable Long id){
    return ResponseEntity.ok(DirectionMapper.mapDirectionToDirectionDTO(this.directionService.createDirection(newDirection, id)));
  }

  //ok
  @PutMapping("/update/{direction_id}")
  public ResponseEntity<DirectionDTO> updateDirection(@Valid @RequestBody Direction updatedDirection,@PathVariable Long direction_id){
    return ResponseEntity.ok(DirectionMapper.mapDirectionToDirectionDTO(this.directionService.updateDirection(updatedDirection, direction_id)));
  }

  //ok
  @DeleteMapping("/delete/{direction_id}")
  public ResponseEntity<Void> deleteDirection(@PathVariable Long direction_id){
    this.directionService.deleteDirection(direction_id);
    return ResponseEntity.noContent().build();
  }

}
