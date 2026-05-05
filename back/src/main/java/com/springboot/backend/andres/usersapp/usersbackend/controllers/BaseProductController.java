package com.springboot.backend.andres.usersapp.usersbackend.controllers;


import com.springboot.backend.andres.usersapp.usersbackend.DTO.*;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Category;
import com.springboot.backend.andres.usersapp.usersbackend.mappers.GeneralMapper;
import com.springboot.backend.andres.usersapp.usersbackend.mappers.ProductMapper;
import com.springboot.backend.andres.usersapp.usersbackend.services.IBaseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/base_products")
public class BaseProductController {
  @Autowired
  private IBaseProductService baseProductService;

  //ok
  @GetMapping("/featured_products")
  public List<BasicProductInfoDTO> findAll(){
    return this.baseProductService.findAllProductsCommerce()
      .stream()
      .map(ProductMapper::mapBaseProductToBasicProductInfoDTO).toList();
  }

  //ok
  @PostMapping("/create")
  public ResponseEntity<?> createNew(@RequestBody CreateBaseProductDTO createBaseProductDTO) {
    Long baseProductId = this.baseProductService.createNew(createBaseProductDTO);

    Map<String, Object> response = new HashMap<>();
    response.put("id", baseProductId);
    response.put("message", "Producto creado exitosamente");

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  //ok
  @GetMapping("/{base_product_id}")
  public ProductDetailDTO findById(@PathVariable Long base_product_id){
    return ProductMapper.mapBaseProductToProductDetail(this.baseProductService.getProductDetail(base_product_id));
  }

  //ok
  @GetMapping("/admin/{base_product_id}")
  public CreateBaseProductDTO findProductAdminDetailById(@PathVariable Long base_product_id){
    return  ProductMapper.mapBaseProductToCreateBaseProductDTO(this.baseProductService.getProductDetail(base_product_id));
  }

  //nuevo
  @PostMapping("/filter")
  public Page<BasicProductInfoDTO> filter(@RequestBody BasicProductFilter filter ){
    Pageable pageable = PageRequest.of(filter.getPage(), filter.getPageSize());
    //return ResponseEntity.ok(salePage.map(SaleMapper::mapSaleToAdminSaleBasicInfoDTO));
    return  this.baseProductService.filter(pageable, filter.getBrandId(), filter.getCategoriesIds()).map(ProductMapper::mapBaseProductToBasicProductInfoDTO);
  }

  //ok
  @PostMapping("/filter/brand/get_list")
  public List<BrandDTO> getBrandList(@RequestBody List<Long> categoriesIds){
    return  this.baseProductService.getBrandList(categoriesIds).stream().map(GeneralMapper::mapBrandToBrandDTO).toList();
  }
}
