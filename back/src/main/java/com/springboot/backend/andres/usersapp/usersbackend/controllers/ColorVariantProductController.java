package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import com.springboot.backend.andres.usersapp.usersbackend.entities.ColorVariantProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.ColorVariantProductImage;
import com.springboot.backend.andres.usersapp.usersbackend.services.IColorVariantProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/color_variant_products")
public class ColorVariantProductController {
  @Autowired
  private IColorVariantProductService colorVariantProductService;

  @PostMapping("/create")
  public ColorVariantProduct create(@RequestBody ColorVariantProduct colorVariantProduct){
    return this.colorVariantProductService.create(colorVariantProduct);
  }

  @PutMapping("/update/{color_variant_product_id}")
  public ColorVariantProduct update(@RequestBody ColorVariantProduct colorVariantProduct,@PathVariable Long color_variant_product_id){
    return this.colorVariantProductService.update(colorVariantProduct, color_variant_product_id);
  }

  @PutMapping("/update/add_image/{color_variant_product_id}")
  public ColorVariantProduct addImage(@RequestBody ColorVariantProductImage colorVariantProductImage,@PathVariable Long color_variant_product_id){
    return  this.colorVariantProductService.addImage(colorVariantProductImage, color_variant_product_id);
  }

  @PutMapping("/update/remove_image/{color_variant_product_id}")
  public ColorVariantProduct removeImage(@RequestBody ColorVariantProductImage colorVariantProductImage,@PathVariable Long color_variant_product_id){
    return this.colorVariantProductService.removeImage(colorVariantProductImage, color_variant_product_id);
  }
}
