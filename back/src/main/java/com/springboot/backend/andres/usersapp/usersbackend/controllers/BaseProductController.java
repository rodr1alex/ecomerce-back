package com.springboot.backend.andres.usersapp.usersbackend.controllers;


import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProductImage;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Brand;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Category;
import com.springboot.backend.andres.usersapp.usersbackend.services.IBaseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/base_products")
public class BaseProductController {
  @Autowired
  private IBaseProductService baseProductService;



  @PostMapping("/create")
  public BaseProduct create(@RequestBody BaseProduct newBaseProduct){
    return this.baseProductService.create(newBaseProduct);
  }

  @GetMapping("/{base_product_id}")
  public BaseProduct findById(@PathVariable Long base_product_id){
    return  this.baseProductService.findById(base_product_id);
  }

  @GetMapping("/featured_products/page/{page}")
  public Page<BaseProduct> getFeaturedProducts(@PathVariable Integer page){
    Pageable pageable = PageRequest.of(page, 40);
    return  this.baseProductService.getFeaturedProducts(pageable);
  }

  @PutMapping("/update/{base_product_id}")
  public BaseProduct update(@RequestBody BaseProduct baseProduct,@PathVariable Long base_product_id){
    return this.baseProductService.update(baseProduct, base_product_id);
  }

  @PutMapping("/update/add_image/{base_product_id}")
  public BaseProduct addImage(@RequestBody BaseProductImage baseProductImage,@PathVariable Long base_product_id){
    return this.baseProductService.addImage(baseProductImage, base_product_id);
  }

  @PutMapping("/update/remove_image/{base_product_id}")
  public BaseProduct removeImage(@RequestBody BaseProductImage baseProductImage,@PathVariable Long base_product_id){
    return this.baseProductService.removeImage(baseProductImage, base_product_id);
  }

  //METODOS DE FILTRADO

  @PostMapping("/filter/brand/{brand_id}/page/{page}")
  public Page<BaseProduct> filterByBrand(@PathVariable Long brand_id,@PathVariable Integer page,@RequestBody List<Category> categoryList ){
    Pageable pageable = PageRequest.of(page, 4);
    return  this.baseProductService.filterByBrand(brand_id, pageable, categoryList);
  }


  @PostMapping("/filter/category_list/page/{page}")
  public Page<BaseProduct> filterByCategoryList(@RequestBody List<Category> categoryList,@PathVariable Integer page){
    Pageable pageable = PageRequest.of(page, 4);
    return this.baseProductService.filterByCategoryList(categoryList, pageable);
  }

  @PostMapping("/filter/brand/get_list")
  public List<Brand> getBrandList(@RequestBody List<Category> categoryList){
    return  this.baseProductService.getBrandList(categoryList);
  }
}
