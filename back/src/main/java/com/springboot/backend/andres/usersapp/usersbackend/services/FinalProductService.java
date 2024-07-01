package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.*;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IBaseProductRepository;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IFinalProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

  @Override
  public FinalProduct create(FinalProduct finalProduct) {
    ColorVariantProduct colorVariantProductDB = this.colorVariantProductService.findById(finalProduct.getColorVariantProduct().getColor_variant_product_id());
    Size sizeDB = this.sizeService.findById(finalProduct.getSize().getSize_id());
    finalProduct.setColorVariantProduct(colorVariantProductDB);
    finalProduct.setSize(sizeDB);
    finalProduct.setColor(colorVariantProductDB.getColor().getName());
    finalProduct.setImg(colorVariantProductDB.getColorVariantProductImageList().get(0).getUrl());
    BaseProduct baseProductDB = this.baseProductRepository.findById(colorVariantProductDB.getBaseProduct().getBase_product_id()).get();
    finalProduct.setBrand(baseProductDB.getBrand().getName());
    if(finalProduct.getFinal_price() == null){
      finalProduct.setFinal_price(baseProductDB.getBase_price());
    }
    if(finalProduct.getFinal_description() == null){
      finalProduct.setFinal_description(baseProductDB.getDescription());
    }
    if(finalProduct.getFinal_chars() == null){
      finalProduct.setFinal_chars(baseProductDB.getChars());
    }
    if(finalProduct.getFinal_specs() == null){
      finalProduct.setFinal_specs(baseProductDB.getSpecs());
    }
    return this.finalProductRepository.save(finalProduct);
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
  public void reduceInventory(List<OrderedProduct> orderedProductList) {
    for (OrderedProduct orderedProduct: orderedProductList){
      FinalProduct finalProductDB = this.findById(orderedProduct.getFinalProduct().getFinal_product_id());
      finalProductDB.setStock(finalProductDB.getStock() - orderedProduct.getQuantity());
      this.finalProductRepository.save(finalProductDB);
    }
  }
}
