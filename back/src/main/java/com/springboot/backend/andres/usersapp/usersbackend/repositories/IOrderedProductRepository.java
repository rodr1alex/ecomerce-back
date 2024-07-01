package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import com.springboot.backend.andres.usersapp.usersbackend.entities.OrderedProduct;
import org.springframework.data.repository.CrudRepository;

public interface IOrderedProductRepository extends CrudRepository<OrderedProduct, Long> {
}
