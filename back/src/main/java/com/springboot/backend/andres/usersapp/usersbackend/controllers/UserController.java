package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.UserDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.UserFilterDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Role;
import com.springboot.backend.andres.usersapp.usersbackend.mappers.UserMapper;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IBaseProductRepository;
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
import com.springboot.backend.andres.usersapp.usersbackend.models.UserRequest;
import com.springboot.backend.andres.usersapp.usersbackend.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private IBaseProductRepository baseProductRepository;

    @GetMapping
    public List<UserDTO> list() {
        return service.findAll().stream().map(UserMapper::mapUserToUserDTO).toList();
    }

    @GetMapping("/page/{page_size}/{page}")
    public Page<User> listPageable(@PathVariable Integer page_size, @PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, page_size);
        return service.findAll(pageable);
    }

    @PostMapping("/filter")
    public Page<UserDTO> filter( @RequestBody UserFilterDTO userFilter){
        return  this.service.filter(userFilter);
    }

    //actualizado
    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Optional<User> userOptional = service.findById(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(UserMapper.mapUserToUserDTO(userOptional.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap("error", "el usuario no se encontro por el id:" + id));
    }

    //actualizado
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.mapUserToUserDTO(service.save(user)));
    }

    //actualizado
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody UserDTO user, BindingResult result, @PathVariable Long id) {

        if (result.hasErrors()) {
            return validation(result);
        }

        Optional<UserDTO> userOptional = service.update(user, id);

        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    //actualizado
  @PutMapping("/update_password/{id}")
  public ResponseEntity<?> updatePassword(@RequestBody User user, @PathVariable Long id) {
    Optional<User> userOptional = service.updatePassword(user, id);
    if (userOptional.isPresent()) {
      return ResponseEntity.ok(UserMapper.mapUserToUserDTO(userOptional.orElseThrow()));
    }
    return ResponseEntity.notFound().build();
  }

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

    //ENDPOINTS DE APOYO

  @GetMapping("/baseproducts")
  private List<BaseProduct> findAllBaseProduct(){
      return (List) this.baseProductRepository.findAll();
  }

  @GetMapping("/baseproducts/{id}")
  private BaseProduct findById(@PathVariable Long id){
      return this.baseProductRepository.findById(id).get();
  }
}
