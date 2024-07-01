package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Cart;
import org.springframework.data.repository.CrudRepository;

public interface ICartRepository extends CrudRepository<Cart, Long> {
}
