package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Color;
import com.springboot.backend.andres.usersapp.usersbackend.entities.ColorVariantProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.ColorVariantProductImage;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IColorVariantProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorVariantProductService implements IColorVariantProductService {
  @Autowired
  private IColorVariantProductRepository colorVariantProductRepository;
  @Autowired
  private IBaseProductService baseProductService;
  @Autowired
  private IColorService colorService;
  @Autowired
  private IColorVariantProductImageService colorVariantProductImageService;

  @Override
  public ColorVariantProduct create(ColorVariantProduct newColorVariantProduct) {
    System.out.println(newColorVariantProduct.toString());
    BaseProduct baseProductDB = this.baseProductService.findById(newColorVariantProduct.getBaseProduct().getBase_product_id());
    newColorVariantProduct.setBaseProduct(baseProductDB);
    Color colorDB = this.colorService.findById(newColorVariantProduct.getColor().getColor_id());
    newColorVariantProduct.setColor(colorDB);
    List<ColorVariantProductImage> colorVariantProductImageListDB = this.colorVariantProductImageService.createWithList(newColorVariantProduct.getColorVariantProductImageList());
    newColorVariantProduct.setColorVariantProductImageList(colorVariantProductImageListDB);
    ColorVariantProduct colorVariantProductDB = this.colorVariantProductRepository.save(newColorVariantProduct);
    this.colorVariantProductImageService.associateWithColorVariantProduct(colorVariantProductImageListDB, colorVariantProductDB);
    //this.baseProductService.associateWithColorVariantProduct(baseProductDB, colorVariantProductDB);
    return colorVariantProductDB;
  }

  @Override
  public ColorVariantProduct findById(Long color_variant_product_id) {
    return this.colorVariantProductRepository.findById(color_variant_product_id).get();
  }

  @Override
  public ColorVariantProduct update(ColorVariantProduct colorVariantProduct, Long color_variant_product_id) {
    ColorVariantProduct colorVariantProductDB  = this.colorVariantProductRepository.findById(color_variant_product_id).get();
    colorVariantProductDB.setColor(this.colorService.findById(colorVariantProduct.getColor().getColor_id()));
    //colorVariantProductDB.setBaseProduct(this.baseProductService.findById(colorVariantProduct.getBaseProduct().getBase_product_id()));
    return this.colorVariantProductRepository.save(colorVariantProductDB);
  }

  @Override
  public ColorVariantProduct addImage(ColorVariantProductImage colorVariantProductImage, Long color_variant_product_id) {
    ColorVariantProduct colorVariantProductDB = this.colorVariantProductRepository.findById(color_variant_product_id).get();
    this.colorVariantProductImageService.createAndAssociate(colorVariantProductImage, colorVariantProductDB);
    return colorVariantProductDB;
  }

  @Override
  public ColorVariantProduct removeImage(ColorVariantProductImage colorVariantProductImage, Long color_variant_product_id) {
    this.colorVariantProductImageService.deleteById(colorVariantProductImage.getColor_variant_product_image_id());
    return this.colorVariantProductRepository.findById(color_variant_product_id).get();
  }
}
