package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Size;
import org.springframework.data.repository.CrudRepository;

public interface ISizeRepository extends CrudRepository<Size, Long> {
}
