package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Brand;
import org.springframework.data.repository.CrudRepository;

public interface IBrandRepository extends CrudRepository<Brand, Long> {
}
