package com.springboot.backend.andres.usersapp.usersbackend.controllers;


import com.springboot.backend.andres.usersapp.usersbackend.DTO.CategoryDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Category;
import com.springboot.backend.andres.usersapp.usersbackend.mappers.GeneralMapper;
import com.springboot.backend.andres.usersapp.usersbackend.services.ICategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/categories")
public class CategoryController {
  @Autowired
  private ICategoryService categoryService;

  //try remove
  @PostMapping("/create")
  public ResponseEntity<Category> create(@Valid @RequestBody Category category){
    return ResponseEntity.status(HttpStatus.CREATED).body(this.categoryService.createCategory(category));
  }

  //ok
  @GetMapping()
  public ResponseEntity<List<CategoryDTO>> findAll(){
    return ResponseEntity.ok(this.categoryService.findAll().stream().map(GeneralMapper::mapCategoryToCategoryDTO).toList());
  }

  //try remove
  @GetMapping("/{category_id}")
  public ResponseEntity<Category> findById(@PathVariable Long category_id){
    return ResponseEntity.ok(this.categoryService.findById(category_id));
  }

  //try remove
  @PutMapping("/update/{category_id}")
  public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category updatedCategory,@PathVariable Long category_id){
    return ResponseEntity.ok(this.categoryService.updateCategory(updatedCategory, category_id));
  }

}
