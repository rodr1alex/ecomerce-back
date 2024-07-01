package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Direction;

public interface IDirectionService {
  public Direction createDirection(Direction newDirection, Long id);
  public Direction updateDirection(Direction updatedDirection, Long direction_id);
  public void deleteDirection(Long direction_id);
}
