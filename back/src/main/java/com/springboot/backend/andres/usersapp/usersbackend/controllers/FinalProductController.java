package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import com.springboot.backend.andres.usersapp.usersbackend.entities.FinalProduct;
import com.springboot.backend.andres.usersapp.usersbackend.services.IFinalProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  @PutMapping("/update/{final_product_id}")
  public FinalProduct update(@RequestBody FinalProduct finalProduct,@PathVariable Long final_product_id){
    return this.finalProductService.update(finalProduct, final_product_id);
  }
}
