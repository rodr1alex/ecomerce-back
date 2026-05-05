package com.springboot.backend.andres.usersapp.usersbackend.mappers;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.DirectionDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Direction;

public class DirectionMapper {

  public static DirectionDTO mapDirectionToDirectionDTO(Direction direction){
    DirectionDTO directionDTO = new DirectionDTO();
    directionDTO.setDirection_id(direction.getDirection_id());
    directionDTO.setCity(direction.getCity());
    directionDTO.setStreet(direction.getStreet());
    directionDTO.setNumber(direction.getNumber());
    return directionDTO;
  }

}
