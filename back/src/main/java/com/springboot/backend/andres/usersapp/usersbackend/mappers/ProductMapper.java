package com.springboot.backend.andres.usersapp.usersbackend.mappers;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.*;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.Color;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.Size;
import com.springboot.backend.andres.usersapp.usersbackend.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

  // Main mapping function
  public static ProductDetail toDetailDto(BaseProduct entity) {
    if (entity == null) return new ProductDetail();

    ProductDetail dto = new ProductDetail();
    dto.setBaseProductId(entity.getBase_product_id());
    dto.setName(entity.getName());
    dto.setBasePrice(entity.getBase_price());
    dto.setBrand(entity.getBrand() != null ? entity.getBrand().getName() : "");
    dto.setChars(entity.getChars());
    dto.setSpecs(entity.getSpecs());

    // Functional mapping of the main image list
    dto.setImageList(mapImages(entity.getBaseProductImageList()));


    dto.setSizesColorsAvailable(toSizesColorsList(entity.getColorVariantProductList()));

    // Functional mapping of the color variants
    dto.setColorsVariantInfo(
      entity.getColorVariantProductList().stream()
        .map(ProductMapper::toColorVariantDto)
        .collect(Collectors.toList())
    );

    return dto;
  }

  //Helper recibe ColorVariantProductList return List<SizesColors>
  private static List<SizesColors> toSizesColorsList(List<ColorVariantProduct> colorVariantProductList){
    List<SizesColors> sizesColorsList = new ArrayList<>();

    for(ColorVariantProduct colorVariantProduct: colorVariantProductList){
      toSizesColorsList(colorVariantProduct).stream().forEach(item -> sizesColorsList.add(item));
    }

    return sizesColorsList;

  }

  private static List<SizesColors> toSizesColorsList(ColorVariantProduct colorVariantProduct){
    List<SizesColors> sizesColorsList = new ArrayList<>();


    List<FinalProduct> finalProductList = colorVariantProduct.getFinalProductList();

    for(FinalProduct finalProduct: finalProductList){
      SizesColors sizesColor = new SizesColors();

      Color colorDto = new Color();
      colorDto.setColor_id(colorVariantProduct.getColor().getColor_id());
      colorDto.setName(colorVariantProduct.getColor().getName());
      sizesColor.setColor(colorDto);

      Size sizeDto = new Size();
      sizeDto.setSize_id(finalProduct.getSize().getSize_id());
      sizeDto.setName(finalProduct.getSize().getName());
      sizesColor.setSize(sizeDto);

      sizesColor.setFinalProductId(finalProduct.getFinal_product_id());

      sizesColorsList.add(sizesColor);

    }

    return sizesColorsList;

  }



  // Helper to map ColorVariantProduct -> ColorVariantInfo
  private static ColorVariantInfo toColorVariantDto(ColorVariantProduct variant) {
    ColorVariantInfo info = new ColorVariantInfo();

    // Map the color sub-object
    Color colorDto = new Color();
    colorDto.setColor_id(variant.getColor().getColor_id());
    colorDto.setName(variant.getColor().getName());
    info.setColor(colorDto);

    // Map the nested images using the same logic as the main list
    info.setImageList(mapImagesForVariant(variant.getColorVariantProductImageList()));

    return info;
  }

  // Generic-like mapping for different image entity types
  private static List<GenericImage> mapImages(List<BaseProductImage> entities) {
    return entities.stream()
      .map(img -> {
        GenericImage g = new GenericImage();
        g.setUrl(img.getUrl());
        return g;
      })
      .collect(Collectors.toList());
  }

  private static List<GenericImage> mapImagesForVariant(List<ColorVariantProductImage> entities) {
    return entities.stream()
      .map(img -> {
        GenericImage g = new GenericImage();
        g.setUrl(img.getUrl());
        return g;
      })
      .collect(Collectors.toList());
  }
}
