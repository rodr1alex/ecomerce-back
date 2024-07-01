package com.springboot.backend.andres.usersapp.usersbackend.services;


import com.springboot.backend.andres.usersapp.usersbackend.entities.Category;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService{
  @Autowired
  private ICategoryRepository categoryRepository;


  @Override
  public Category createCategory(Category newCategory) {
    return this.categoryRepository.save(newCategory);
  }

  @Override
  public List<Category> findAll() {
    return (List<Category>) this.categoryRepository.findAll();
  }

  @Override
  public Category findById(Long category_id) {
    return this.categoryRepository.findById(category_id).get();
  }

  @Override
  public Category updateCategory(Category updatedCategory, Long category_id) {
    Category categoryDB = this.categoryRepository.findById(category_id).get();
    categoryDB.setName(updatedCategory.getName());
    return this.categoryRepository.save(categoryDB);
  }

  @Override
  public List<Category> findByList(List<Category> categoryList) {
    List<Category> categoryListDB = new ArrayList<>();
    for(Category category: categoryList){
      Category categoryDB = this.findById(category.getCategory_id());
      categoryListDB.add(categoryDB);
    }
    return categoryListDB;
  }
}
