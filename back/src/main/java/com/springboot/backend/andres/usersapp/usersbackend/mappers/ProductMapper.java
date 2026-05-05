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
    baseProductCommerce.setBaseProductId(baseProduct.getBase_product_id());
    baseProductCommerce.setName(baseProduct.getName());
    baseProductCommerce.setBasePrice(baseProduct.getBase_price());
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
    dto.setBase_price(baseProduct.getBase_price());
    dto.setChars(baseProduct.getChars());
    dto.setSpecs(baseProduct.getSpecs());
    dto.setBrand_id(baseProduct.getBrand().getBrand_id());

    dto.setCategories_id(baseProduct.getCategoryList().stream()
      .map(Category::getCategory_id)
      .collect(Collectors.toList()));

    dto.setBaseProductImagesURL(baseProduct.getBaseProductImageList().stream()
      .map(BaseProductImage::getUrl)
      .collect(Collectors.toList()));

    dto.setColorVariantProductList(baseProduct.getColorVariantProductList().stream()
      .map(variant -> {
        CreateColorVariantProductDTO variantDto = new CreateColorVariantProductDTO();
        variantDto.setColor_id(variant.getColor().getColor_id());

        variantDto.setColorVariantProductImagesURL(variant.getColorVariantProductImageList().stream()
          .map(ColorVariantProductImage::getUrl)
          .collect(Collectors.toList()));

        variantDto.setFinalProductList(variant.getFinalProductList().stream()
          .map(finalProd -> {
            CreateFinalProductDTO finalDto = new CreateFinalProductDTO();
            finalDto.setStock(finalProd.getStock());
            finalDto.setFinal_price(finalProd.getFinal_price());
            finalDto.setSize_id(finalProd.getSize().getSize_id());
            return finalDto;
          }).collect(Collectors.toList()));

        return variantDto;
      }).collect(Collectors.toList()));

    return dto;
  }


  public static OrderedProductDetailDTO mapOrderedProductToOrderedProductDetailDTO(OrderedProduct orderedProduct){
    OrderedProductDetailDTO orderedProductDetailDTO = new OrderedProductDetailDTO();

    orderedProductDetailDTO.setOrdered_product_id(orderedProduct.getOrdered_product_id());
    orderedProductDetailDTO.setFinal_product_id(orderedProduct.getFinalProduct().getFinal_product_id());
    orderedProductDetailDTO.setBase_product_id(orderedProduct.getFinalProduct().getColorVariantProduct().getBaseProduct().getBase_product_id());
    orderedProductDetailDTO.setQuantity(orderedProduct.getQuantity());
    orderedProductDetailDTO.setOriginalQuantity(orderedProduct.getOriginalquantity());
    orderedProductDetailDTO.setImgUrl(orderedProduct.getFinalProduct().getImg());
    orderedProductDetailDTO.setBrand(orderedProduct.getFinalProduct().getColorVariantProduct().getBaseProduct().getBrand().getName());
    orderedProductDetailDTO.setProductName(orderedProduct.getFinalProduct().getColorVariantProduct().getBaseProduct().getName());
    orderedProductDetailDTO.setColor(orderedProduct.getFinalProduct().getColorVariantProduct().getColor().getName());
    orderedProductDetailDTO.setSize(orderedProduct.getFinalProduct().getSize().getName());
    orderedProductDetailDTO.setPriceAtPurchase(orderedProduct.getPrice_at_purchase());

    return  orderedProductDetailDTO;
  }

  // Main mapping function
  public static ProductDetailDTO mapBaseProductToProductDetail(BaseProduct baseProduct) {
    if (baseProduct == null) return new ProductDetailDTO();

    ProductDetailDTO productDetail = new ProductDetailDTO();
    productDetail.setBaseProductId(baseProduct.getBase_product_id());
    productDetail.setName(baseProduct.getName());
    productDetail.setBasePrice(baseProduct.getBase_price());
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
    baseProductInfo.setBaseProductId(baseProduct.getBase_product_id());
    baseProductInfo.setName(baseProduct.getName());
    baseProductInfo.setBasePrice(baseProduct.getBase_price());
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
        colorDto.setColor_id(colorVariantProduct.getColor().getColor_id());
        colorDto.setName(colorVariantProduct.getColor().getName());
        colorDto.setHex_code_color(colorVariantProduct.getColor().getHex_code_color());
        sizesColor.setColor(colorDto);

        SizeDTO sizeDto = new SizeDTO();
        sizeDto.setSize_id(finalProduct.getSize().getSize_id());
        sizeDto.setName(finalProduct.getSize().getName());
        sizesColor.setSize(sizeDto);

        sizesColor.setFinalProductId(finalProduct.getFinal_product_id());
        return sizesColor;
      }).collect(Collectors.toList());

  }



  // Helper to map ColorVariantProduct -> ColorVariantInfo
  private static ColorVariantInfo mapColorVariantProductToColorVariantInfo(ColorVariantProduct colorVariantProduct) {
    ColorVariantInfo colorVariantInfo = new ColorVariantInfo();

    // Map the color sub-object
    ColorDTO colorDto = new ColorDTO();
    colorDto.setColor_id(colorVariantProduct.getColor().getColor_id());
    colorDto.setName(colorVariantProduct.getColor().getName());
    colorDto.setHex_code_color(colorVariantProduct.getColor().getHex_code_color());
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

    adminFinalProductDTO.setFinal_product_id(finalProduct.getFinal_product_id());
    adminFinalProductDTO.setFinal_price(finalProduct.getFinal_price());
    adminFinalProductDTO.setColor(finalProduct.getColorVariantProduct().getColor().getName());
    adminFinalProductDTO.setSize(finalProduct.getSize().getName());
    adminFinalProductDTO.setBrand(finalProduct.getColorVariantProduct().getBaseProduct().getBrand().getName());
    adminFinalProductDTO.setName(finalProduct.getColorVariantProduct().getBaseProduct().getName());
    adminFinalProductDTO.setStock(finalProduct.getStock());
    adminFinalProductDTO.setBase_product_id(finalProduct.getColorVariantProduct().getBaseProduct().getBase_product_id());

    return adminFinalProductDTO;
  }
}



