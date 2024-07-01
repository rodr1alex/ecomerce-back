package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Direction;
import com.springboot.backend.andres.usersapp.usersbackend.entities.User;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IDirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectionService implements IDirectionService{
  @Autowired
  private IDirectionRepository directionRepository;
  @Autowired
  private UserService userService;

  @Override
  public Direction createDirection(Direction newDirection, Long id) {
    User user = this.userService.findById(id).get();
    newDirection.setUser(user);
    return this.directionRepository.save(newDirection);
  }

  @Override
  public Direction updateDirection(Direction updatedDirection, Long direction_id) {
    Direction direction = this.directionRepository.findById(direction_id).get();
    direction.setCity(updatedDirection.getCity());
    direction.setStreet(updatedDirection.getStreet());
    direction.setNumber(updatedDirection.getNumber());
    return this.directionRepository.save(direction);
  }

  @Override
  public void deleteDirection(Long direction_id) {
    this.directionRepository.deleteById(direction_id);
  }


}
