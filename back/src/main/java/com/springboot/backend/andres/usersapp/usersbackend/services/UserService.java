package com.springboot.backend.andres.usersapp.usersbackend.services;

import java.util.List;
import java.util.Optional;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;

import com.springboot.backend.andres.usersapp.usersbackend.entities.User;
import com.springboot.backend.andres.usersapp.usersbackend.models.UserRequest;

public interface UserService {
    List<User> findAll();
    Page<User> findAll(Pageable pageable);
    Page<User> filter(Pageable pageable, Role role);
    Optional<User> findById(@NonNull Long id);
    User save(User user);
    Optional<User> update(User user, Long id);
    Optional<User> updatePassword(User user, Long id);
    void deleteById(Long id);
}
