package com.springboot.backend.andres.usersapp.usersbackend.controllers;


import com.springboot.backend.andres.usersapp.usersbackend.DTO.CategoryDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Category;
import com.springboot.backend.andres.usersapp.usersbackend.mappers.GeneralMapper;
import com.springboot.backend.andres.usersapp.usersbackend.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/categories")
public class CategoryController {
  @Autowired
  private ICategoryService categoryService;

  @PostMapping("/create")
  public Category create(@RequestBody Category category){
    return  this.categoryService.createCategory(category);
  }

  @GetMapping()
  public List<CategoryDTO> findAll(){
    return this.categoryService.findAll().stream().map(GeneralMapper::mapCategoryToCategoryDTO).toList();
  }

  @GetMapping("/{category_id}")
  public Category findById(@PathVariable Long category_id){
    return this.categoryService.findById(category_id);
  }

  @PutMapping("/update/{category_id}")
  public Category updateCategory(@RequestBody Category updatedCategory,@PathVariable Long category_id){
    return this.categoryService.updateCategory(updatedCategory, category_id);
  }

}
