package com.springboot.backend.andres.usersapp.usersbackend.mappers;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.*;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.ColorDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.SizeDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

  public static BasicProductInfoDTO mapBaseProductToBasicProductInfoDTO(BaseProduct baseProduct){
    BasicProductInfoDTO baseProductCommerce = new BasicProductInfoDTO();
    baseProductCommerce.setBaseProductId(baseProduct.getId());
    baseProductCommerce.setName(baseProduct.getName());
    baseProductCommerce.setBasePrice(baseProduct.getBasePrice());
    baseProductCommerce.setBrand(baseProduct.getBrand().getName());
    List<GenericImage> imageList = new ArrayList<>();
    List<BaseProductImage> baseProductImageList = baseProduct.getBaseProductImageList();
    for(BaseProductImage imageItem: baseProductImageList){
      GenericImage image = new GenericImage();
      image.setUrl(imageItem.getUrl());
      imageList.add(image);
    }
    baseProductCommerce.setImageList(imageList);
    return baseProductCommerce;
  }

  public static CreateBaseProductDTO mapBaseProductToCreateBaseProductDTO(BaseProduct baseProduct) {
    CreateBaseProductDTO dto = new CreateBaseProductDTO();

    dto.setName(baseProduct.getName());
    dto.setBasePrice(baseProduct.getBasePrice());
    dto.setChars(baseProduct.getChars());
    dto.setSpecs(baseProduct.getSpecs());
    dto.setBrandId(baseProduct.getBrand().getId());

    dto.setCategoriesId(baseProduct.getCategoryList().stream()
      .map(Category::getId)
      .collect(Collectors.toList()));

    dto.setBaseProductImagesURL(baseProduct.getBaseProductImageList().stream()
      .map(BaseProductImage::getUrl)
      .collect(Collectors.toList()));

    dto.setColorVariantProductList(baseProduct.getColorVariantProductList().stream()
      .map(variant -> {
        CreateColorVariantProductDTO variantDto = new CreateColorVariantProductDTO();
        variantDto.setColorId(variant.getColor().getId());

        variantDto.setColorVariantProductImagesURL(variant.getColorVariantProductImageList().stream()
          .map(ColorVariantProductImage::getUrl)
          .collect(Collectors.toList()));

        variantDto.setFinalProductList(variant.getFinalProductList().stream()
          .map(finalProd -> {
            CreateFinalProductDTO finalDto = new CreateFinalProductDTO();
            finalDto.setStock(finalProd.getStock());
            finalDto.setFinalPrice(finalProd.getFinalPrice());
            finalDto.setSizeId(finalProd.getSize().getId());
            return finalDto;
          }).collect(Collectors.toList()));

        return variantDto;
      }).collect(Collectors.toList()));

    return dto;
  }


  public static OrderedProductDetailDTO mapOrderedProductToOrderedProductDetailDTO(OrderedProduct orderedProduct){
    OrderedProductDetailDTO orderedProductDetailDTO = new OrderedProductDetailDTO();

    orderedProductDetailDTO.setOrderedProductId(orderedProduct.getId());
    orderedProductDetailDTO.setFinalProductId(orderedProduct.getFinalProduct().getId());
    orderedProductDetailDTO.setBaseProductId(orderedProduct.getFinalProduct().getColorVariantProduct().getBaseProduct().getId());
    orderedProductDetailDTO.setQuantity(orderedProduct.getQuantity());
    orderedProductDetailDTO.setOriginalQuantity(orderedProduct.getOriginalQuantity());
    orderedProductDetailDTO.setImgUrl(orderedProduct.getFinalProduct().getImg());
    orderedProductDetailDTO.setBrand(orderedProduct.getFinalProduct().getColorVariantProduct().getBaseProduct().getBrand().getName());
    orderedProductDetailDTO.setProductName(orderedProduct.getFinalProduct().getColorVariantProduct().getBaseProduct().getName());
    orderedProductDetailDTO.setColor(orderedProduct.getFinalProduct().getColorVariantProduct().getColor().getName());
    orderedProductDetailDTO.setSize(orderedProduct.getFinalProduct().getSize().getName());
    orderedProductDetailDTO.setPriceAtPurchase(orderedProduct.getPriceAtPurchase());

    return  orderedProductDetailDTO;
  }

  // Main mapping function
  public static ProductDetailDTO mapBaseProductToProductDetail(BaseProduct baseProduct) {
    if (baseProduct == null) return new ProductDetailDTO();

    ProductDetailDTO productDetail = new ProductDetailDTO();
    productDetail.setBaseProductId(baseProduct.getId());
    productDetail.setName(baseProduct.getName());
    productDetail.setBasePrice(baseProduct.getBasePrice());
    productDetail.setBrand(baseProduct.getBrand() != null ? baseProduct.getBrand().getName() : "Desconocido");
    productDetail.setChars(baseProduct.getChars());
    productDetail.setSpecs(baseProduct.getSpecs());

    // Functional mapping of the main image list
    productDetail.setImageList(mapBaseProductImagesToGenericImages(baseProduct.getBaseProductImageList()));


    productDetail.setSizesColorsAvailable(toSizesColorsList(baseProduct.getColorVariantProductList()));

    // Functional mapping of the color variants
    productDetail.setColorsVariantInfo(
      baseProduct.getColorVariantProductList().stream()
        .map(ProductMapper::mapColorVariantProductToColorVariantInfo)
        .collect(Collectors.toList())
    );

    return productDetail;
  }

  public static BasicProductInfoDTO mapBaseProductToBaseProductInfo(BaseProduct baseProduct) {
    if (baseProduct == null) return new BasicProductInfoDTO();

    BasicProductInfoDTO baseProductInfo = new BasicProductInfoDTO();
    baseProductInfo.setBaseProductId(baseProduct.getId());
    baseProductInfo.setName(baseProduct.getName());
    baseProductInfo.setBasePrice(baseProduct.getBasePrice());
    baseProductInfo.setBrand(baseProduct.getBrand().getName());
    List<GenericImage> imageList = new ArrayList<>();
    List<BaseProductImage> baseProductImageList = baseProduct.getBaseProductImageList();
    for(BaseProductImage imageItem: baseProductImageList){
      GenericImage image = new GenericImage();
      image.setUrl(imageItem.getUrl());
      imageList.add(image);
    }
    baseProductInfo.setImageList(imageList);

    return baseProductInfo;
  }

  //Helper recibe ColorVariantProductList return List<SizesColors>
  private static List<SizesColors> toSizesColorsList(List<ColorVariantProduct> colorVariantProductList){
    List<SizesColors> sizesColorsList = new ArrayList<>();

    colorVariantProductList
      .forEach(colorVariantProduct -> toSizesColorsList(colorVariantProduct)
        .forEach(item -> sizesColorsList.add(item)));


    return sizesColorsList;

  }

  private static List<SizesColors> toSizesColorsList(ColorVariantProduct colorVariantProduct){

    return colorVariantProduct.getFinalProductList().stream()
      .map(finalProduct -> {
        SizesColors sizesColor = new SizesColors();

        ColorDTO colorDto = new ColorDTO();
        colorDto.setId(colorVariantProduct.getColor().getId());
        colorDto.setName(colorVariantProduct.getColor().getName());
        colorDto.setHexCodeColor(colorVariantProduct.getColor().getHexCodeColor());
        sizesColor.setColor(colorDto);

        SizeDTO sizeDto = new SizeDTO();
        sizeDto.setId(finalProduct.getSize().getId());
        sizeDto.setName(finalProduct.getSize().getName());
        sizesColor.setSize(sizeDto);

        sizesColor.setFinalProductId(finalProduct.getId());
        return sizesColor;
      }).collect(Collectors.toList());

  }



  // Helper to map ColorVariantProduct -> ColorVariantInfo
  private static ColorVariantInfo mapColorVariantProductToColorVariantInfo(ColorVariantProduct colorVariantProduct) {
    ColorVariantInfo colorVariantInfo = new ColorVariantInfo();

    // Map the color sub-object
    ColorDTO colorDto = new ColorDTO();
    colorDto.setId(colorVariantProduct.getColor().getId());
    colorDto.setName(colorVariantProduct.getColor().getName());
    colorDto.setHexCodeColor(colorVariantProduct.getColor().getHexCodeColor());
    colorVariantInfo.setColor(colorDto);

    // Map the nested images using the same logic as the main list
    colorVariantInfo.setImageList(mapColorVariantProductImagesToGenericImages(colorVariantProduct.getColorVariantProductImageList()));

    return colorVariantInfo;
  }

  // Generic-like mapping for different image entity types
  private static List<GenericImage> mapBaseProductImagesToGenericImages(List<BaseProductImage> baseProductImages) {
    return baseProductImages.stream()
      .map(img -> {
        GenericImage g = new GenericImage();
        g.setUrl(img.getUrl());
        return g;
      })
      .collect(Collectors.toList());
  }

  private static List<GenericImage> mapColorVariantProductImagesToGenericImages(List<ColorVariantProductImage> colorVariantProductImages) {
    return colorVariantProductImages.stream()
      .map(img -> {
        GenericImage g = new GenericImage();
        g.setUrl(img.getUrl());
        return g;
      })
      .collect(Collectors.toList());
  }

  public static AdminFinalProductDTO mapFinalProductToAdminFinalProductDTO(FinalProduct finalProduct) {
    AdminFinalProductDTO adminFinalProductDTO = new AdminFinalProductDTO();

    adminFinalProductDTO.setFinalProductId(finalProduct.getId());
    adminFinalProductDTO.setFinalPrice(finalProduct.getFinalPrice());
    adminFinalProductDTO.setColor(finalProduct.getColorVariantProduct().getColor().getName());
    adminFinalProductDTO.setSize(finalProduct.getSize().getName());
    adminFinalProductDTO.setBrand(finalProduct.getColorVariantProduct().getBaseProduct().getBrand().getName());
    adminFinalProductDTO.setName(finalProduct.getColorVariantProduct().getBaseProduct().getName());
    adminFinalProductDTO.setStock(finalProduct.getStock());
    adminFinalProductDTO.setBaseProductId(finalProduct.getColorVariantProduct().getBaseProduct().getId());

    return adminFinalProductDTO;
  }
}



