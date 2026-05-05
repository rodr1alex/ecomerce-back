package com.springboot.backend.andres.usersapp.usersbackend.mappers;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.ProductDetailDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.UserDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.User;

import java.util.stream.Collector;

public class UserMapper {

  public static UserDTO mapUserToUserDTO(User user){
    UserDTO userDTO = new UserDTO();

    boolean isAdmin = user.getRoles().size() == 2;
    userDTO.setId(user.getId());
    userDTO.setName(user.getName());
    userDTO.setLastname(user.getLastname());
    userDTO.setEmail(user.getEmail());
    userDTO.setUsername(user.getUsername());
    userDTO.setAdmin(isAdmin);
    userDTO.setDirectionList(user.getDirectionList().stream().map(DirectionMapper::mapDirectionToDirectionDTO).toList());

    return userDTO;
  }

}
