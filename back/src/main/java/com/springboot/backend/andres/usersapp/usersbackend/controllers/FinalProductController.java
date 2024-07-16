package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Category;
import com.springboot.backend.andres.usersapp.usersbackend.entities.FinalProduct;
import com.springboot.backend.andres.usersapp.usersbackend.services.IFinalProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/final_products")
public class FinalProductController {
  @Autowired
  private IFinalProductService finalProductService;

  @PostMapping("/create")
  private FinalProduct create(@RequestBody FinalProduct finalProduct){
    return this.finalProductService.create(finalProduct);
  }

  @GetMapping("/{size}/{page}")
  public Page<FinalProduct> getAll(@PathVariable Integer page,@PathVariable Integer size){
    Pageable pageable = PageRequest.of(page, size);
    return  this.finalProductService.findAll(pageable);
  }

  @PostMapping("/filter/{brand_id}/{color_id}/{size_id}/{pageSize}/{page}")
  public Page<FinalProduct> filter(@PathVariable Long brand_id,@PathVariable Long color_id,@PathVariable Long size_id,@RequestBody List<Category> categoryList,@PathVariable Integer page,@PathVariable Integer pageSize){
    Pageable pageable = PageRequest.of(page, pageSize);
    return this.finalProductService.filter(pageable, brand_id, color_id, size_id, categoryList);
  }


  @PutMapping("/update/{final_product_id}")
  public FinalProduct update(@RequestBody FinalProduct finalProduct,@PathVariable Long final_product_id){
    return this.finalProductService.update(finalProduct, final_product_id);
  }

}
