package com.springboot.backend.andres.usersapp.usersbackend.mappers;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.BrandDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.CategoryDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.ColorDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.SizeDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Brand;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Category;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Color;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Size;

public class GeneralMapper {

  public static CategoryDTO mapCategoryToCategoryDTO(Category category){
    CategoryDTO categoryDTO = new CategoryDTO();
    categoryDTO.setCategoryId(category.getId());
    categoryDTO.setName(category.getName());
    return  categoryDTO;
  }

  public static BrandDTO mapBrandToBrandDTO(Brand brand){
    return new BrandDTO(brand.getId(), brand.getName());
  }

  public static ColorDTO mapColorToColorDTO(Color color){
    return  new ColorDTO(color.getId(), color.getName(), color.getHexCodeColor());
  }

  public static SizeDTO mapSizeToSizeDTO(Size size){
    return new SizeDTO(size.getId(), size.getName());
  }

}
