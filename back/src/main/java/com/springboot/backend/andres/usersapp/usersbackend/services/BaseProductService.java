package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.*;
import com.springboot.backend.andres.usersapp.usersbackend.entities.*;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BaseProductService implements IBaseProductService{
  @Autowired
  private IBaseProductRepository baseProductRepository;
  @Autowired
  private IBrandService brandService;
  @Autowired
  private IBaseProductImageService baseProductImageService;
  @Autowired
  private ICategoryService categoryService;
  @Autowired
  private IFinalProductRepository finalProductRepository;
  @Autowired
  private IColorVariantProductRepository colorVariantProductRepository;
  @Autowired
  private IColorRepository colorRepository;
  @Autowired
  IColorVariantProductImageRepository colorVariantProductImageRepository;
  @Autowired
  ISizeRepository sizeRepository;


  @Override
  @Transactional
  public Long createNew(CreateBaseProductDTO createBaseProductDTO) {
    BaseProduct baseProduct = new BaseProduct();
    baseProduct.setName(createBaseProductDTO.getName());
    baseProduct.setBase_price(createBaseProductDTO.getBase_price());
    baseProduct.setChars(createBaseProductDTO.getChars());
    baseProduct.setSpecs(createBaseProductDTO.getSpecs());
    baseProduct.setBrand(this.brandService.findById(createBaseProductDTO.getBrand_id()));
    Set<Category> categories = createBaseProductDTO.getCategories_id().stream().map(this.categoryService::findById).collect(Collectors.toSet());
    baseProduct.setCategoryList(categories);
    BaseProduct baseProductCreated = this.baseProductRepository.save(baseProduct);
    setBaseProductsImages(baseProductCreated, createBaseProductDTO.getBaseProductImagesURL());
    createBaseProductDTO.getColorVariantProductList().forEach(item -> createColorVariantProducts(baseProductCreated, item));
    return baseProductCreated.getBase_product_id();
  }

  private void setBaseProductsImages( BaseProduct baseProduct, List<String> urls){
    if (urls == null) return;

    List<BaseProductImage> baseProductImageList = urls.stream()
      .map(url -> this.baseProductImageService.create(new BaseProductImage(null, url, baseProduct)))
      .collect(Collectors.toList());

    baseProduct.setBaseProductImageList(baseProductImageList);
    this.baseProductRepository.save(baseProduct);
  }

  private void createColorVariantProducts(BaseProduct baseProduct, CreateColorVariantProductDTO createColorVariantProductDTO){
    ColorVariantProduct colorVariantProduct = new ColorVariantProduct();
    colorVariantProduct.setBaseProduct(baseProduct);
    colorVariantProduct.setColor(colorRepository.findById(createColorVariantProductDTO.getColor_id()).get());
    ColorVariantProduct colorVariantProductCreated = colorVariantProductRepository.save(colorVariantProduct);
    setColorVariantProductsImages(colorVariantProductCreated, createColorVariantProductDTO.getColorVariantProductImagesURL());
    createColorVariantProductDTO.getFinalProductList().forEach(item -> createFinalProducts(colorVariantProductCreated, item));
  }

  private void setColorVariantProductsImages(ColorVariantProduct colorVariantProduct, List<String> urls){
    if (urls == null) return;

    List<ColorVariantProductImage> colorVariantProductImageList = urls.stream()
      .map(url -> this.colorVariantProductImageRepository.save(new ColorVariantProductImage(null, url, colorVariantProduct)))
      .collect(Collectors.toList());

    colorVariantProduct.setColorVariantProductImageList(colorVariantProductImageList);
    this.colorVariantProductRepository.save(colorVariantProduct);
  }

  private void createFinalProducts(ColorVariantProduct colorVariantProduct, CreateFinalProductDTO createFinalProductDTO ){
    FinalProduct finalProduct = new FinalProduct();
    finalProduct.setStock(createFinalProductDTO.getStock());
    finalProduct.setFinal_price(createFinalProductDTO.getFinal_price());
    finalProduct.setColorVariantProduct(colorVariantProduct);
    finalProduct.setSize(sizeRepository.findById(createFinalProductDTO.getSize_id()).get());
    finalProduct.setImg(colorVariantProduct.getColorVariantProductImageList().get(0).getUrl()); //verificar si esta era la imagen que necesito
    finalProductRepository.save(finalProduct);
  }

  @Override
  public Page<BaseProduct> filter(Pageable pageable, Long brandId, List<Long> categoriesIds) {

    if (categoriesIds != null && !categoriesIds.isEmpty()) {
      return baseProductRepository.findByBrandAndAllCategories(brandId, categoriesIds, (long) categoriesIds.size(), pageable);
    }

    if (brandId != null) {
      return baseProductRepository.findByBrandId(brandId, pageable);
    }

    return baseProductRepository.findAll(pageable);
  }

  @Override
  public List<BaseProduct> findAllProductsCommerce() {
    return (List<BaseProduct>) baseProductRepository.findAll();

  }

  @Override
  public BaseProduct getProductDetail(Long id) {
    return baseProductRepository.findById(id).get();
  }

  @Override
  public List<Brand> getBrandList(List<Long> categoriesIds) {
    if (categoriesIds == null || categoriesIds.isEmpty()) {
      return new ArrayList<>();
    }
    Long size = (long) categoriesIds.size();
    return this.baseProductRepository.findBrandsWithAllCategories(categoriesIds, size);
  }


}
