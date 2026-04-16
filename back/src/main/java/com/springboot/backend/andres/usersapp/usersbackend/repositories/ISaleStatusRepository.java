package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import com.springboot.backend.andres.usersapp.usersbackend.entities.SaleStatus;
import org.springframework.data.repository.CrudRepository;

public interface ISaleStatusRepository extends CrudRepository<SaleStatus, Long> {
}
