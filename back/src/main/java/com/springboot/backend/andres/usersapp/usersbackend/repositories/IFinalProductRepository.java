package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import com.springboot.backend.andres.usersapp.usersbackend.entities.FinalProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface IFinalProductRepository extends CrudRepository<FinalProduct, Long> {

  Page<FinalProduct> findAll(Pageable pageable);
}
