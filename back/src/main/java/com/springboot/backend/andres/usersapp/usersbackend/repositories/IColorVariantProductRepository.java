package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import com.springboot.backend.andres.usersapp.usersbackend.entities.ColorVariantProduct;
import org.springframework.data.repository.CrudRepository;

public interface IColorVariantProductRepository extends CrudRepository<ColorVariantProduct, Long> {
}
