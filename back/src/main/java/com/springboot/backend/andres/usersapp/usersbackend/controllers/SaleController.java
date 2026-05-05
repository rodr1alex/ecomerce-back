package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.*;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Sale;
import com.springboot.backend.andres.usersapp.usersbackend.mappers.SaleMapper;
import com.springboot.backend.andres.usersapp.usersbackend.services.IFinalProductService;
import com.springboot.backend.andres.usersapp.usersbackend.services.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/sales")
public class SaleController {
  @Autowired
  private ISaleService saleService;
  @Autowired
  private IFinalProductService finalProductService;


  //ok
  @GetMapping("/{sale_id}")
  public AdminSaleDetailDTO findById(@PathVariable Long sale_id){
    return SaleMapper.mapSaleToSaleDetailDTO(this.saleService.findById(sale_id));
  }

  //ok
  @GetMapping("/statuses")
  public List<SaleStatusDTO> getSaleStatuses(){
    return saleService.getAllSaleStatus().stream().map(SaleMapper::mapSaleStatusToSaleStatusDTO).toList();
  }

  //ok
  @PostMapping("/filter")
  public ResponseEntity<Page<AdminSaleBasicInfoDTO>> filter(@RequestBody SaleFilterDTO filters) {

    int size = (filters.getPageSize() != null && filters.getPageSize() > 0) ? filters.getPageSize() : 10;
    Pageable pageable = PageRequest.of(filters.getPage(), size);

    Page<Sale> salePage = this.saleService.filter(
      pageable,
      filters.getUser_id(),
      filters.getStartDate(),
      filters.getEndDate(),
      filters.getStartTotal(),
      filters.getEndTotal(),
      filters.getSaleStatus_id()
    );

    return ResponseEntity.ok(salePage.map(SaleMapper::mapSaleToAdminSaleBasicInfoDTO));
  }

  //ok
  @PostMapping("/create")
  private ResponseEntity<?> createSale(@RequestBody CartForPaymentDTO cart){
    List<Long> productsNoStock = this.finalProductService.verifyInventory(cart.getProducts());

    Map<String, Object> response = new HashMap<>();
    response.put("Error no se encuentran los productos (final_product_id): ", productsNoStock);

    if(!productsNoStock.isEmpty()){
      return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    Sale sale = this.saleService.createSale(cart);
    return ResponseEntity.status(200).body(sale.getSale_id());
  }

  //ok
  @PutMapping("/modify/{sale_id}")
  private ResponseEntity<?> modify(@PathVariable Long sale_id,@RequestBody List<ProductReturned> orderedProductList){
     return ResponseEntity.status(HttpStatus.OK).body(SaleMapper.mapSaleToSaleDetailDTO(this.saleService.modifySale(sale_id, orderedProductList)));
  }

  //ok
  @PutMapping("/cancel/{sale_id}")
  private ResponseEntity<?> cancelSale(@PathVariable Long sale_id){
    return  ResponseEntity.status(HttpStatus.OK).body(SaleMapper.mapSaleToSaleDetailDTO(this.saleService.cancelSale(sale_id)));
  }


}
