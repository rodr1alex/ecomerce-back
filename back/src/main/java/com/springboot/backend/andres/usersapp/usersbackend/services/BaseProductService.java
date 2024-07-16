package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.*;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IBaseProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

  @Override
  public BaseProduct create(BaseProduct newBaseProduct) {
    Brand brandDB = this.brandService.findById(newBaseProduct.getBrand().getBrand_id());
    List<Category> categoryListDB  = this.categoryService.findByList(newBaseProduct.getCategoryList());
    List<BaseProductImage> baseProductImageListDB = this.baseProductImageService.createWithList(newBaseProduct.getBaseProductImageList());
    newBaseProduct.setBaseProductImageList(baseProductImageListDB);
    newBaseProduct.setBrand(brandDB);
    newBaseProduct.setCategoryList(categoryListDB);
    BaseProduct baseProductDB = this.baseProductRepository.save(newBaseProduct);
    this.baseProductImageService.associateWithBaseProduct(baseProductImageListDB, baseProductDB);
    this.brandService.associateWithBaseProduct(brandDB, baseProductDB);
    return baseProductDB;
  }

  @Override
  public BaseProduct findById(Long base_product_id) {
    return this.baseProductRepository.findById(base_product_id).get();
  }

  @Override
  public Page<BaseProduct> getFeaturedProducts(Pageable pageable) {
    return this.baseProductRepository.findAll(pageable);
  }


  @Override
  public BaseProduct update(BaseProduct updatedBaseProduct, Long base_product_id) {
    BaseProduct baseProductDB = this.baseProductRepository.findById(base_product_id).get();
    baseProductDB.setBrand(this.brandService.findById(updatedBaseProduct.getBrand().getBrand_id()));
    List<Category> categoryListDB = new ArrayList<>();
    for (Category category: updatedBaseProduct.getCategoryList()){
      categoryListDB.add(this.categoryService.findById(category.getCategory_id()));
    }
    baseProductDB.setCategoryList(categoryListDB);
    baseProductDB.setName(updatedBaseProduct.getName());
    baseProductDB.setBase_price(updatedBaseProduct.getBase_price());
    baseProductDB.setDescription(updatedBaseProduct.getDescription());
    baseProductDB.setChars(updatedBaseProduct.getChars());
    baseProductDB.setSpecs(updatedBaseProduct.getSpecs());
    return this.baseProductRepository.save(baseProductDB);
  }

  @Override
  public BaseProduct addImage(BaseProductImage baseProductImage, Long base_product_id) {
    BaseProduct baseProductDB = this.baseProductRepository.findById(base_product_id).get();
    this.baseProductImageService.createAndAssociate(baseProductImage, baseProductDB);
    return baseProductDB;
  }

  @Override
  public BaseProduct removeImage(BaseProductImage baseProductImage, Long base_product_id) {
    this.baseProductImageService.delete(baseProductImage.getBase_product_image_id());
    return this.baseProductRepository.findById(base_product_id).get();
  }

  @Override
  public Page<BaseProduct>  filterByBrand(Long brand_id, Pageable pageable, List<Category> categoryList) {
    //List<BaseProduct> baseProductListDB = (List<BaseProduct>) this.baseProductRepository.findAll();
    List<BaseProduct> baseProductListDB = (List<BaseProduct>) this.baseProductRepository.findAll();
    for(Category category: categoryList){
      System.out.println("Filtrando  por: " + this.categoryService.findById(category.getCategory_id()).getName());
      baseProductListDB = this.filterByCategory(baseProductListDB, category.getCategory_id());
    }
    Brand brandDB = this.brandService.findById(brand_id);
    List<BaseProduct> filtredList = new ArrayList<>();
    for(BaseProduct baseProductDB: baseProductListDB){
      if(Objects.equals(baseProductDB.getBrand().getBrand_id(), brandDB.getBrand_id())){
        filtredList.add(baseProductDB);
      }
    }
    return this.convertListToPage(filtredList, pageable);

  }

  @Override
  public List<FinalProduct>  filterByBrandAndCategoryListAndColorAndSize(Long brand_id, Long color_id, Long size_id, List<Category> categoryList) {
    List<BaseProduct> baseProductListDB = (List<BaseProduct>) this.baseProductRepository.findAll();
    if(categoryList.get(0).getCategory_id() > 0){
      for(Category category: categoryList){
        System.out.println("Filtrando  por: " + this.categoryService.findById(category.getCategory_id()).getName());
        baseProductListDB = this.filterByCategory(baseProductListDB, category.getCategory_id());
      }
    }

    List<BaseProduct> filtredList = new ArrayList<>();
    for(BaseProduct baseProductDB: baseProductListDB){
      if(brand_id > 0){
        if(Objects.equals(baseProductDB.getBrand().getBrand_id(), brand_id)){
          filtredList.add(baseProductDB);
        }
      }else {
        filtredList.add(baseProductDB);
      }

    }
    //Filtrando por color
    List<ColorVariantProduct> colorVariantProductListFiltred = new ArrayList<>();
    for (BaseProduct baseProductDB: filtredList){
      for(ColorVariantProduct colorVariantProductDB: baseProductDB.getColorVariantProductList()){
        if(color_id > 0){
          if(Objects.equals(colorVariantProductDB.getColor().getColor_id(), color_id)){
            colorVariantProductListFiltred.add(colorVariantProductDB);
          }
        }else {
          colorVariantProductListFiltred.add(colorVariantProductDB);
        }
      }
    }

    //Filtrando por talla
    List<FinalProduct> finalProductListFiltred = new ArrayList<>();
    for (ColorVariantProduct colorVariantProductDB: colorVariantProductListFiltred){
      for(FinalProduct finalProductDB: colorVariantProductDB.getFinalProductList()){
        if(size_id > 0){
          if(Objects.equals(finalProductDB.getSize().getSize_id(), size_id)){
            finalProductListFiltred.add(finalProductDB);
          }
        }else{
          finalProductListFiltred.add(finalProductDB);
        }

      }
    }

    return  finalProductListFiltred;

  }

  @Override
  public Page<BaseProduct> filterByCategoryList(List<Category> categoryList, Pageable pageable) {
    List<Brand> brandList = new ArrayList<>();
    List<BaseProduct> baseProductListDB = (List<BaseProduct>) this.baseProductRepository.findAll();
    for(Category category: categoryList){
      System.out.println("Filtrando  por: " + this.categoryService.findById(category.getCategory_id()).getName());
      baseProductListDB = this.filterByCategory(baseProductListDB, category.getCategory_id());
    }
    for(BaseProduct baseProduct:baseProductListDB ){
      System.out.println("agregando: " + baseProduct.getBrand().getName());
      brandList.add(baseProduct.getBrand());
    }
    return this.convertListToPage(baseProductListDB, pageable);
  }

  @Override
  public List<Brand> getBrandList(List<Category> categoryList) {
    List<Brand> brandList = new ArrayList<>();
    List<BaseProduct> baseProductListDB = (List<BaseProduct>) this.baseProductRepository.findAll();
    for(Category category: categoryList){
      System.out.println("Filtrando  por: " + this.categoryService.findById(category.getCategory_id()).getName());
      baseProductListDB = this.filterByCategory(baseProductListDB, category.getCategory_id());
    }
    for(BaseProduct baseProduct:baseProductListDB ){
      brandList.add(baseProduct.getBrand());
    }
    return brandList;

  }


  //METODOS AUXILIARES
  public List<BaseProduct> filterByCategory(List<BaseProduct> baseProductList ,Long category_id){
    List<BaseProduct> filtredList = new ArrayList<>();
    for(BaseProduct baseProductDB: baseProductList){
      for (Category categoryDB : baseProductDB.getCategoryList()){
        if(Objects.equals(categoryDB.getCategory_id(), category_id)){
          filtredList.add(baseProductDB);
        }
      }
    }
    return  filtredList;
  }

  public  Page<BaseProduct> convertListToPage(List<BaseProduct> list, Pageable pageable) {
    if (list == null || list.isEmpty()) {
      return new PageImpl<>(List.of(), pageable, 0);
    }

    int start = (int) pageable.getOffset();
    int end = Math.min((start + pageable.getPageSize()), list.size());

    if (start > end) {
      return new PageImpl<>(List.of(), pageable, list.size());
    }

    List<BaseProduct> subList = list.subList(start, end);
    return new PageImpl<>(subList, pageable, list.size());
  }


  /*@Override
  public void associateWithColorVariantProduct(BaseProduct baseProduct, ColorVariantProduct colorVariantProduct) {
    List<ColorVariantProduct> colorVariantProductListDB = baseProduct.getColorVariantProductList();
    colorVariantProductListDB.add(colorVariantProduct);
    this.baseProductRepository.save(baseProduct);
  }*/
}
