package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import com.springboot.backend.andres.usersapp.usersbackend.entities.BannerImage;
import org.springframework.data.repository.CrudRepository;

public interface IBannerImageRepository extends CrudRepository<BannerImage, Long> {
}
