package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface IBaseProductRepository extends CrudRepository<BaseProduct, Long> {
  //Page<User> findAll(Pageable pageable);

  Page<BaseProduct> findAll(Pageable pageable);
}
