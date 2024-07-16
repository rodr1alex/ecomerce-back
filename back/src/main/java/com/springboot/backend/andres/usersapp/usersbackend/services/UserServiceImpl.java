package com.springboot.backend.andres.usersapp.usersbackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Role;
import com.springboot.backend.andres.usersapp.usersbackend.entities.User;
import com.springboot.backend.andres.usersapp.usersbackend.models.IUser;
import com.springboot.backend.andres.usersapp.usersbackend.models.UserRequest;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.RoleRepository;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List) this.repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

  @Override
  public Page<User> filter(Pageable pageable, Role role) {
    List<User> userListDB = (List<User>) this.repository.findAll();
    List<User> filtredUserList = new ArrayList<>();
    if(role.getId() > 0){
      if(role.getId() == 1){
        for(User userDB: userListDB){
          if (userDB.getRoles().size() == 1){
            filtredUserList.add(userDB);
          }
        }
      }else {
        for (User userDB : userListDB) {
          if (userDB.getRoles().size() == 2) {
            filtredUserList.add(userDB);
          }
        }
      }
    }else {
      filtredUserList = userListDB;
    }

    return this.convertListToPage(filtredUserList, pageable);
  }

  @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(@NonNull Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public User save(User user) {
        user.setRoles(getRoles(user));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    @Transactional
    public Optional<User> update(User user, Long id) {
        Optional<User> userOptional = repository.findById(id);

        if (userOptional.isPresent()) {
            User userDb = userOptional.get();
            userDb.setEmail(user.getEmail());
            userDb.setLastname(user.getLastname());
            userDb.setName(user.getName());
            userDb.setUsername(user.getUsername());
            return Optional.of(repository.save(userDb));
        }
        return Optional.empty();
    }
  @Override
  @Transactional
  public Optional<User> updatePassword(User user, Long id) {
    Optional<User> userOptional = repository.findById(id);

    if (userOptional.isPresent()) {
      User userDb = userOptional.get();
      userDb.setPassword(passwordEncoder.encode(user.getPassword()));
      //user.setPassword(passwordEncoder.encode(user.getPassword()));
      return Optional.of(repository.save(userDb));
    }
    return Optional.empty();
  }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private List<Role> getRoles(IUser user) {
        List<Role> roles = new ArrayList<>();
        Optional<Role> optionalRoleUser = roleRepository.findByName("ROLE_USER");
        optionalRoleUser.ifPresent(roles::add);

        if (user.isAdmin()) {
            Optional<Role> optionalRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
            optionalRoleAdmin.ifPresent(roles::add);
        }
        return roles;
    }

  public  Page<User> convertListToPage(List<User> list, Pageable pageable) {
    if (list == null || list.isEmpty()) {
      return new PageImpl<>(List.of(), pageable, 0);
    }

    int start = (int) pageable.getOffset();
    int end = Math.min((start + pageable.getPageSize()), list.size());

    if (start > end) {
      return new PageImpl<>(List.of(), pageable, list.size());
    }

    List<User> subList = list.subList(start, end);
    return new PageImpl<>(subList, pageable, list.size());
  }


}
