package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.DirectionDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Direction;

import java.util.List;

public interface IDirectionService {
  public List<DirectionDTO> getDirectionsByUser(Long user_id);
  public Direction createDirection(Direction newDirection, Long id);
  public Direction updateDirection(Direction updatedDirection, Long direction_id);
  public void deleteDirection(Long direction_id);
}
