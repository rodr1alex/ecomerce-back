package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Category;

import java.util.List;

public interface ICategoryService {
  public Category createCategory(Category newCategory);
  public List<Category> findAll();
  public Category findById(Long category_id);
  public Category updateCategory(Category updatedCategory, Long category_id);
  public List<Category> findByList(List<Category> categoryList);
}
