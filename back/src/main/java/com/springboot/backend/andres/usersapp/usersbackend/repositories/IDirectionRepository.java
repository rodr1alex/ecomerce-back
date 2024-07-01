package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Direction;
import org.springframework.data.repository.CrudRepository;

public interface IDirectionRepository extends CrudRepository<Direction, Long> {
}
