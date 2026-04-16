package com.springboot.backend.andres.usersapp.usersbackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.UserDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.UserFilterDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Direction;
import com.springboot.backend.andres.usersapp.usersbackend.mappers.UserMapper;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IDirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
    @Autowired
    private IDirectionRepository directionRepository;


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
  public Page<UserDTO> filter(UserFilterDTO userFilter) {
      // Pageable pageable, Role role

    Pageable pageable = PageRequest.of(userFilter.getPage(), userFilter.getPage_size());
    List<User> userListDB = (List<User>) this.repository.findAll();
    List<User> filtredUserList = new ArrayList<>();

    if(userFilter.getAdmin() == null){
      return this.convertListToPage(userListDB.stream()
        .map(UserMapper::mapUserToUserDTO).toList(), pageable);
    }

    if(userFilter.getAdmin()){
      filtredUserList = userListDB.stream()
        .filter(userDB -> userDB.getRoles().size() == 2)
        .collect(Collectors.toList());
    }else{
      filtredUserList = userListDB.stream()
        .filter(userDB -> userDB.getRoles().size() == 1)
        .collect(Collectors.toList());
    }

    return this.convertListToPage(filtredUserList.stream()
      .map(UserMapper::mapUserToUserDTO).toList(), pageable);
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
        List<Direction> directions = user.getDirectionList();
        user.setDirectionList(null);
        User newUser = repository.save(user);

      List<Direction> directionsNew = directions.stream().map(direction -> {
          direction.setUser(newUser);
          return this.directionRepository.save(direction);
        }).toList();
        newUser.setDirectionList(directionsNew);
        return newUser;
    }

    @Override
    @Transactional
    public Optional<UserDTO> update(UserDTO userDTO, Long id) {
        Optional<User> userOptional = repository.findById(id);

        if (userOptional.isPresent()) {
            User userDb = userOptional.get();
            userDb.setEmail(userDTO.getEmail());
            userDb.setLastname(userDTO.getLastname());
            userDb.setName(userDTO.getName());
            userDb.setUsername(userDTO.getUsername());
            return Optional.of(UserMapper.mapUserToUserDTO(repository.save(userDb)));
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

  public  Page<UserDTO> convertListToPage(List<UserDTO> list, Pageable pageable) {
    if (list == null || list.isEmpty()) {
      return new PageImpl<>(List.of(), pageable, 0);
    }

    int start = (int) pageable.getOffset();
    int end = Math.min((start + pageable.getPageSize()), list.size());

    if (start > end) {
      return new PageImpl<>(List.of(), pageable, list.size());
    }

    List<UserDTO> subList = list.subList(start, end);
    return new PageImpl<>(subList, pageable, list.size());
  }


}
