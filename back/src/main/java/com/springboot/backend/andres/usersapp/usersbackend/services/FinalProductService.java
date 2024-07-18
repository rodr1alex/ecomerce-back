package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.*;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IBaseProductRepository;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IFinalProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FinalProductService implements IFinalProductService{
  @Autowired
  private IFinalProductRepository finalProductRepository;
  @Autowired
  private IColorVariantProductService colorVariantProductService;
  @Autowired
  private ISizeService sizeService;
  @Autowired
  private IBaseProductRepository baseProductRepository;
  @Autowired
  private IBaseProductService baseProductService;

  @Override
  public FinalProduct create(FinalProduct finalProduct) {
    ColorVariantProduct colorVariantProductDB = this.colorVariantProductService.findById(finalProduct.getColorVariantProduct().getColor_variant_product_id());
    Size sizeDB = this.sizeService.findById(finalProduct.getSize().getSize_id());
    BaseProduct baseProductDB = this.baseProductRepository.findById(colorVariantProductDB.getBaseProduct().getBase_product_id()).get();
    finalProduct.setColorVariantProduct(colorVariantProductDB);
    finalProduct.setSize(sizeDB);
    finalProduct.setName(baseProductDB.getName());
    finalProduct.setBrand(baseProductDB.getBrand().getName());
    finalProduct.setColor(colorVariantProductDB.getColor().getName());
    finalProduct.setBase_product_id(baseProductDB.getBase_product_id());
    if(!colorVariantProductDB.getColorVariantProductImageList().isEmpty()){
      finalProduct.setImg(colorVariantProductDB.getColorVariantProductImageList().get(0).getUrl());
    }else{
      finalProduct.setImg(baseProductDB.getBaseProductImageList().get(0).getUrl());
    }
    //Si es que el final_price en null
    if(finalProduct.getFinal_price() == null){
      finalProduct.setFinal_price(baseProductDB.getBase_price());
    }
    return this.finalProductRepository.save(finalProduct);
  }



  @Override
  public Page<FinalProduct> findAll(Pageable pageable) {
    return this.finalProductRepository.findAll(pageable);
  }


  @Override
  public FinalProduct findById(Long final_product_id) {
    return this.finalProductRepository.findById(final_product_id).get();
  }

  @Override
  public FinalProduct update(FinalProduct finalProduct, Long final_product_id) {
    FinalProduct finalProductDB = this.finalProductRepository.findById(final_product_id).get();
    finalProductDB.setSize(this.sizeService.findById(finalProduct.getSize().getSize_id()));
    return this.finalProductRepository.save(finalProductDB);
  }

  @Override
  public List<FinalProduct> verifyInventory(List<OrderedProduct> orderedProductList) {
    List<FinalProduct> insuficientStockList = new ArrayList<>();
    for (OrderedProduct orderedProduct: orderedProductList){
      FinalProduct finalProductDB = this.findById(orderedProduct.getFinalProduct().getFinal_product_id());
      if(finalProductDB.getStock() < orderedProduct.getQuantity()){
        insuficientStockList.add(finalProductDB);
      }
    }
    return insuficientStockList;
  }

  @Override
  public void modifyInventory(List<OrderedProduct> orderedProductList) {
    for (OrderedProduct orderedProduct: orderedProductList){
      FinalProduct finalProductDB = this.findById(orderedProduct.getFinalProduct().getFinal_product_id());
        finalProductDB.setStock(finalProductDB.getStock() + orderedProduct.getQuantity()); //trabaja con diferencial standart
      this.finalProductRepository.save(finalProductDB);
    }
  }

  @Override
  public Page<FinalProduct> filter(Pageable pageable, Long brand_id, Long color_id, Long size_id, List<Category> categoryList) {
    List<FinalProduct> finalProductListFiltred = this.baseProductService.filterByBrandAndCategoryListAndColorAndSize(brand_id, color_id, size_id, categoryList);
    return this.convertListToPage(finalProductListFiltred, pageable);
  }

  public  Page<FinalProduct> convertListToPage(List<FinalProduct> list, Pageable pageable) {
    if (list == null || list.isEmpty()) {
      return new PageImpl<>(List.of(), pageable, 0);
    }

    int start = (int) pageable.getOffset();
    int end = Math.min((start + pageable.getPageSize()), list.size());

    if (start > end) {
      return new PageImpl<>(List.of(), pageable, list.size());
    }

    List<FinalProduct> subList = list.subList(start, end);
    return new PageImpl<>(subList, pageable, list.size());
  }

}
