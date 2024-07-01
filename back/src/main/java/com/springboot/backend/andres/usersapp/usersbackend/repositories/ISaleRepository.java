package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Sale;
import org.springframework.data.repository.CrudRepository;

public interface ISaleRepository extends CrudRepository<Sale, Long> {
}
