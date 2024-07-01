package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import com.springboot.backend.andres.usersapp.usersbackend.entities.FinalProduct;
import org.springframework.data.repository.CrudRepository;

public interface IFinalProductRepository extends CrudRepository<FinalProduct, Long> {
}
