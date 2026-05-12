package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.UserDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.UserFilterDTO;
import com.springboot.backend.andres.usersapp.usersbackend.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.andres.usersapp.usersbackend.entities.User;
import com.springboot.backend.andres.usersapp.usersbackend.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;


    //ok
    @GetMapping
        public ResponseEntity<List<UserDTO>> list() {
                return ResponseEntity.ok(service.findAll().stream().map(UserMapper::mapUserToUserDTO).toList());
    }

    //ok
    @PostMapping("/filter")
        public ResponseEntity<Page<UserDTO>> filter(@Valid @RequestBody UserFilterDTO filters){
      if (filters.getPage() == null) {
        throw new IllegalArgumentException("page es requerido");
      }
      int size = (filters.getPageSize() != null && filters.getPageSize() > 0) ? filters.getPageSize() : 10;
      Pageable pageable = PageRequest.of(filters.getPage(), size);

      Page<User> users = service.filter(pageable, filters.getAdmin());

            return ResponseEntity.ok(users.map(UserMapper::mapUserToUserDTO));
    }

    //ok
    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Optional<User> userOptional = service.findById(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(UserMapper.mapUserToUserDTO(userOptional.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap("error", "el usuario no se encontro por el id:" + id));
    }

    //ok
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.mapUserToUserDTO(service.save(user)));
    }

    //ok
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody UserDTO user, BindingResult result, @PathVariable Long id) {

        if (result.hasErrors()) {
            return validation(result);
        }

        Optional<User> userOptional = service.update(user, id);

        if (userOptional.isPresent()) {
            return ResponseEntity.ok(UserMapper.mapUserToUserDTO(userOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    //ok
  @PutMapping("/update_password/{id}")
    public ResponseEntity<?> updatePassword(@RequestBody User user, @PathVariable Long id) {
    Optional<User> userOptional = service.updatePassword(user, id);
    if (userOptional.isPresent()) {
      return ResponseEntity.ok(UserMapper.mapUserToUserDTO(userOptional.orElseThrow()));
    }
    return ResponseEntity.notFound().build();
  }


  //try remove
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
      Optional<User> userOptional = service.findById(id);
      if (userOptional.isPresent()) {
          service.deleteById(id);
          return ResponseEntity.noContent().build();
      }
      return ResponseEntity.notFound().build();
  }

  private ResponseEntity<?> validation(BindingResult result) {
      Map<String, String> errors = new HashMap<>();
      result.getFieldErrors().forEach(error -> {
          errors.put(error.getField(), "El campo " + error.getField() + " " + error.getDefaultMessage());
      });
      return ResponseEntity.badRequest().body(errors);
  }

}
