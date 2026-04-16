package com.springboot.backend.andres.usersapp.usersbackend.mappers;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.DirectionDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Direction;

import java.util.List;
import java.util.stream.Collectors;

public class DirectionMapper {
  public static List<DirectionDTO> mapDirectionsToDirectiosDTO(List<Direction> directionList){
      return directionList.stream()
        .map(direction -> {
          DirectionDTO directionDTO = new DirectionDTO();
          directionDTO.setDirection_id(direction.getDirection_id());
          directionDTO.setCity(direction.getCity());
          directionDTO.setStreet(direction.getStreet());
          directionDTO.setNumber(direction.getNumber());
          return directionDTO;
        }).collect(Collectors.toList());
  }


  public static DirectionDTO mapDirectionToDirectioDTO(Direction direction){
    DirectionDTO directionDTO = new DirectionDTO();
    directionDTO.setDirection_id(direction.getDirection_id());
    directionDTO.setCity(direction.getCity());
    directionDTO.setStreet(direction.getStreet());
    directionDTO.setNumber(direction.getNumber());
    return directionDTO;
  }


}
