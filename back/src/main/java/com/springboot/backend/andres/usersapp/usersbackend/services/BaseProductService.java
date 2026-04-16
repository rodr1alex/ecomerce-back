package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.*;
import com.springboot.backend.andres.usersapp.usersbackend.entities.*;
import com.springboot.backend.andres.usersapp.usersbackend.mappers.ProductMapper;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
  public BaseProduct create(BaseProduct newBaseProduct) {
    Brand brandDB = this.brandService.findById(newBaseProduct.getBrand().getBrand_id());
    List<Category> categoryListDB  =  new ArrayList<>();
    List<BaseProductImage> baseProductImageListDB = this.baseProductImageService.createWithList(newBaseProduct.getBaseProductImageList());
    newBaseProduct.setBaseProductImageList(baseProductImageListDB);
    newBaseProduct.setBrand(brandDB);
    newBaseProduct.setCategoryList((Set<Category>) categoryListDB);
    BaseProduct baseProductDB = this.baseProductRepository.save(newBaseProduct);
    this.baseProductImageService.associateWithBaseProduct(baseProductImageListDB, baseProductDB);
    this.brandService.associateWithBaseProduct(brandDB, baseProductDB);

    return baseProductDB;
  }

  @Override
  public Long createNew(CreateBaseProductDTO createBaseProductDTO) {
    //paso1 crear base_product
    BaseProduct baseProduct = new BaseProduct();
    baseProduct.setName(createBaseProductDTO.getName());
    baseProduct.setBase_price(createBaseProductDTO.getBase_price());
    baseProduct.setChars(createBaseProductDTO.getChars());
    baseProduct.setSpecs(createBaseProductDTO.getSpecs());
    baseProduct.setBrand(this.brandService.findById(createBaseProductDTO.getBrand_id()));

    Set<Category> categories = createBaseProductDTO.getCategories_id().stream().map(item -> {
      return this.categoryService.findById(item);
    }).collect(Collectors.toSet());

    baseProduct.setCategoryList((Set<Category>) categories);

    BaseProduct baseProductCreated = this.baseProductRepository.save(baseProduct);

    setBaseProductsImages(baseProductCreated, createBaseProductDTO.getBaseProductImagesURL());

    //paso2 recorrer color_variantproducot
    createBaseProductDTO.getColorVariantProductList().forEach(item -> {
      createColorVariantProducts(baseProductCreated, item);
    });

    return baseProductCreated.getBase_product_id();
  }

  private void setBaseProductsImages( BaseProduct baseProduct, List<String> urls){
    if (urls == null) return;

    List<BaseProductImage> baseProductImageList = urls.stream().map(url -> {
      return (this.baseProductImageService.create(new BaseProductImage(null, url, baseProduct)));
    }).collect(Collectors.toList());

    baseProduct.setBaseProductImageList(baseProductImageList);
    this.baseProductRepository.save(baseProduct);
  }

  private void createColorVariantProducts(BaseProduct baseProduct, CreateColorVariantProductDTO createColorVariantProductDTO){
    ColorVariantProduct colorVariantProduct = new ColorVariantProduct();
    colorVariantProduct.setBaseProduct(baseProduct);
    colorVariantProduct.setColor(colorRepository.findById(createColorVariantProductDTO.getColor_id()).get());
    ColorVariantProduct colorVariantProductCreated = colorVariantProductRepository.save(colorVariantProduct);

    setColorVariantProductsImages(colorVariantProductCreated, createColorVariantProductDTO.getColorVariantProductImagesURL());

    //paso 2.1 recorrer final_products
    createColorVariantProductDTO.getFinalProductList().forEach(item -> {
      createFinalProducts(colorVariantProductCreated, item);
    });
  }

  private void setColorVariantProductsImages(ColorVariantProduct colorVariantProduct, List<String> urls){
    if (urls == null) return;

    List<ColorVariantProductImage> colorVariantProductImageList = urls.stream().map(url -> {
      return (this.colorVariantProductImageRepository.save(new ColorVariantProductImage(null, url, colorVariantProduct)));
    }).collect(Collectors.toList());

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
    baseProductDB.setCategoryList((Set<Category>) categoryListDB);
    baseProductDB.setName(updatedBaseProduct.getName());
    baseProductDB.setBase_price(updatedBaseProduct.getBase_price());
    baseProductDB.setChars(updatedBaseProduct.getChars());
    baseProductDB.setSpecs(updatedBaseProduct.getSpecs());

    //actualizar finalProducts...
    List<FinalProduct> finalProductListDB = (List<FinalProduct>) this.finalProductRepository.findAll();
    for(FinalProduct finalProductDB: finalProductListDB){
      //comentado por el nuevo refactor
//      if(Objects.equals(finalProductDB.getBase_product_id(), base_product_id)){
//        finalProductDB.setBrand(baseProductDB.getBrand().getName());
//        finalProductDB.setName(baseProductDB.getName());
//        //  MUY IMPORTANTE FALTA ACTUALIZAR PRECIOS!!
//        this.finalProductRepository.save(finalProductDB);
//      }
    }

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
  public Page<BasicProductInfoDTO>  filterByBrand(Long brand_id, Pageable pageable, List<Category> categoryList) {
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
  public List<FinalProduct>  filterByBrandAndCategoryListAndColorAndSize(Long brand_id, Long color_id, Long size_id, List<Long> categories) {
    List<BaseProduct> baseProductListDB = (List<BaseProduct>) this.baseProductRepository.findAll();
    if(!categories.isEmpty()){
      for(Long category_id: categories){
        baseProductListDB = this.filterByCategory(baseProductListDB, category_id);
      }
    }

    List<BaseProduct> filtredList = new ArrayList<>();
    for(BaseProduct baseProductDB: baseProductListDB){
      if(brand_id !=null){
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
        if(color_id != null){
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
        if(size_id != null){
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
  public List<BasicProductInfoDTO> findAllProductsCommerce() {
    List<BaseProduct> baseProducts = (List<BaseProduct>) baseProductRepository.findAll();
    List<BasicProductInfoDTO> baseProductCommerceList = new ArrayList<>();
    for (BaseProduct item:baseProducts){
      BasicProductInfoDTO baseProductCommerce = new BasicProductInfoDTO();
      baseProductCommerce.setBaseProductId(item.getBase_product_id());
      baseProductCommerce.setName(item.getName());
      baseProductCommerce.setBasePrice(item.getBase_price());
      baseProductCommerce.setBrand(item.getBrand().getName());
      List<GenericImage> imageList = new ArrayList<>();
      List<BaseProductImage> baseProductImageList = item.getBaseProductImageList();
      for(BaseProductImage imageItem: baseProductImageList){
        GenericImage image = new GenericImage();
        image.setUrl(imageItem.getUrl());
        imageList.add(image);
      }
      baseProductCommerce.setImageList(imageList);
      baseProductCommerceList.add(baseProductCommerce);
    }
    return baseProductCommerceList;
  }

  @Override
  public ProductDetailDTO getProductDetail(Long id) {
    return baseProductRepository.findById(id)
      .map(ProductMapper::mapBaseProductToProductDetail) // Use our custom mapper
      .orElseGet(ProductDetailDTO::new);  // Returns the "Dummy" safe object we created earlier
  }



  @Override
  public Page<BasicProductInfoDTO> filterByCategoryList(List<Long> categoriesIds, Pageable pageable) {
    Long size = (long) categoriesIds.size();
    Page<BaseProduct> baseProductsFiltered = this.baseProductRepository.findByAllCategories(categoriesIds, size, pageable);
    return baseProductsFiltered.map(ProductMapper::mapBaseProductToBaseProductInfo);
  }


  @Override
  public List<BrandDTO> getBrandList(List<Long> categoriesIds) {
    if (categoriesIds == null || categoriesIds.isEmpty()) {
      return new ArrayList<>();
    }
    Long size = (long) categoriesIds.size();
    return this.baseProductRepository.findBrandsWithAllCategories(categoriesIds, size);
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

  public  Page<BasicProductInfoDTO> convertListToPage(List<BaseProduct> list, Pageable pageable) {
    if (list == null || list.isEmpty()) {
      return new PageImpl<>(List.of(), pageable, 0);
    }

    int start = (int) pageable.getOffset();
    int end = Math.min((start + pageable.getPageSize()), list.size());

    List<BasicProductInfoDTO> baseProductCommerceList = new ArrayList<>();
    for (BaseProduct item:list){
      BasicProductInfoDTO baseProductCommerce = new BasicProductInfoDTO();
      baseProductCommerce.setBaseProductId(item.getBase_product_id());
      baseProductCommerce.setName(item.getName());
      baseProductCommerce.setBasePrice(item.getBase_price());
      baseProductCommerce.setBrand(item.getBrand().getName());
      List<GenericImage> imageList = new ArrayList<>();
      List<BaseProductImage> baseProductImageList = item.getBaseProductImageList();
      for(BaseProductImage imageItem: baseProductImageList){
        GenericImage image = new GenericImage();
        image.setUrl(imageItem.getUrl());
        imageList.add(image);
      }
      baseProductCommerce.setImageList(imageList);
      baseProductCommerceList.add(baseProductCommerce);
    }
    //return baseProductCommerceList;



    if (start > end) {
      return new PageImpl<>(List.of(), pageable, list.size());
    }

    List<BasicProductInfoDTO> subList = baseProductCommerceList.subList(start, end);
    return new PageImpl<>(subList, pageable, list.size());
  }


  /*@Override
  public void associateWithColorVariantProduct(BaseProduct baseProduct, ColorVariantProduct colorVariantProduct) {
    List<ColorVariantProduct> colorVariantProductListDB = baseProduct.getColorVariantProductList();
    colorVariantProductListDB.add(colorVariantProduct);
    this.baseProductRepository.save(baseProduct);
  }*/
}
