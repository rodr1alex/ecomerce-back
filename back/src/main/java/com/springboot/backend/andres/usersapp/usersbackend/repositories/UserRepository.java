package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.andres.usersapp.usersbackend.entities.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findAll(Pageable pageable);

    Optional<User> findByUsername(String name);

  @Query("SELECT DISTINCT u FROM User u " +
    "LEFT JOIN u.roles r " +
    "WHERE (:admin IS NULL) " + // Si es null, pasa esta condición y muestra todo
    "OR (:admin = true AND r.name = 'ROLE_ADMIN') " +
    "OR (:admin = false AND NOT EXISTS " +
    "(SELECT r2 FROM u.roles r2 WHERE r2.name = 'ROLE_ADMIN'))")
  Page<User> filterByRole(@Param("admin") Boolean admin, Pageable pageable);

}
