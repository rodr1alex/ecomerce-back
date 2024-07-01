package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Color;
import org.springframework.data.repository.CrudRepository;

public interface IColorRepository extends CrudRepository<Color, Long> {
}
