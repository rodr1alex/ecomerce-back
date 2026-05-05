package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.AdminFinalProductDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.FilterAdminProduct;
import com.springboot.backend.andres.usersapp.usersbackend.mappers.ProductMapper;
import com.springboot.backend.andres.usersapp.usersbackend.services.IFinalProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/final_products")
public class FinalProductController {
  @Autowired
  private IFinalProductService finalProductService;

  //ok
  @PostMapping("/filter")
  public ResponseEntity<Page<AdminFinalProductDTO>> filter(@RequestBody FilterAdminProduct filters) {
    Pageable pageable = PageRequest.of(filters.getPage(), filters.getPageSize());
    return ResponseEntity.ok(this.finalProductService.filter(pageable, filters.getBrandId(), filters.getColorId(), filters.getSizeId(), filters.getCategories()).map(ProductMapper::mapFinalProductToAdminFinalProductDTO));
  }


}
