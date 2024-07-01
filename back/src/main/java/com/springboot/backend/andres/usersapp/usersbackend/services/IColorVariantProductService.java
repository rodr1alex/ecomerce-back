package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.ColorVariantProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.ColorVariantProductImage;

public interface IColorVariantProductService {
  public ColorVariantProduct create(ColorVariantProduct newColorVariantProduct);
  public ColorVariantProduct findById(Long color_variant_product_id);
  public ColorVariantProduct update(ColorVariantProduct colorVariantProduct, Long color_variant_product_id);
  public ColorVariantProduct addImage(ColorVariantProductImage colorVariantProductImage, Long color_variant_product_id);
  public ColorVariantProduct removeImage(ColorVariantProductImage colorVariantProductImage, Long color_variant_product_id);
}
