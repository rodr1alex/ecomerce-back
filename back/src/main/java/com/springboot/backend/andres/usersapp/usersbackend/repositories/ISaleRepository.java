package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ISaleRepository extends CrudRepository<Sale, Long> {
//Page<User> findAll(Pageable pageable);
  Page<Sale> findAll(Pageable pageable);
}
