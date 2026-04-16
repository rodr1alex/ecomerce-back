package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.*;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Cart;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Direction;
import com.springboot.backend.andres.usersapp.usersbackend.entities.OrderedProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Sale;
import com.springboot.backend.andres.usersapp.usersbackend.mappers.SaleMapper;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IFinalProductRepository;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.ISaleStatusRepository;
import com.springboot.backend.andres.usersapp.usersbackend.services.ICartService;
import com.springboot.backend.andres.usersapp.usersbackend.services.IFinalProductService;
import com.springboot.backend.andres.usersapp.usersbackend.services.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/sales")
public class SaleController {
  @Autowired
  private ISaleService saleService;
  @Autowired
  private IFinalProductService finalProductService;
  @Autowired
  private ICartService cartService;


  @GetMapping("/{sale_id}")
  public SaleDetailDTO findById(@PathVariable Long sale_id){
    return SaleMapper.mapSaleToSaleDetailDTO(this.saleService.findById(sale_id));
  }

  @GetMapping("/statuses")
  public List<SaleStatusDTO> getSaleStatuses(){
    return saleService.getAllSaleStatus().stream().map(SaleMapper::mapSaleStatusToSaleStatusDTO).toList();
  }

  @GetMapping("/{pageSize}/{page}")
  private Page<Sale> findAll(@PathVariable Integer pageSize,@PathVariable Integer page){
    Pageable pageable = PageRequest.of(page, pageSize);
    return this.saleService.findAll(pageable);
  }

  @PostMapping("/filter")
  private ResponseEntity<Page<SaleDTO>> filter(@RequestBody SaleFilter filters) {
    // Definimos el Pageable usando los datos del filtro
    Pageable pageable = PageRequest.of(filters.getPage(), filters.getPageSize());

    // NOTA: Aquí podrías manejar las fechas que vienen en el filtro
    // o mantener estas por defecto según tu lógica actual
    Date startDate = new Date();
    Date endDate = new Date();

    // Ejecutamos la búsqueda filtrada
    Page<Sale> salePage = this.saleService.filter(
      pageable,
      filters.getUser_id(),
      startDate,
      endDate,
      filters.getStartTotal(),
      filters.getEndTotal(),
      filters.getSaleStatus_id()
    );

    // Mapeamos a DTO y envolvemos en un ResponseEntity para un estándar REST más limpio
    return ResponseEntity.ok(salePage.map(SaleMapper::mapSaleToSaleDTO));
  }

  @PostMapping("/create")
  private ResponseEntity<?> createSale(@RequestBody CartDTO cart){
    List<FinalProductDTO> productsNoStock = this.finalProductService.verifyInventory(cart.getProducts());

    if(!productsNoStock.isEmpty()){
      return ResponseEntity.status(HttpStatus.CONFLICT).body(productsNoStock);
    }

    Sale sale = this.saleService.createSale(cart);
    return ResponseEntity.status(200).body(sale.getSale_id());
  }

  @PutMapping("/modify/{sale_id}")
  private ResponseEntity<?> modify(@PathVariable Long sale_id,@RequestBody List<ProductReturned> orderedProductList){
     return ResponseEntity.status(HttpStatus.OK).body(this.saleService.modifySale(sale_id, orderedProductList));
  }

  @PutMapping("/cancel/{sale_id}")
  private ResponseEntity<?> cancelSale(@PathVariable Long sale_id){
    return  ResponseEntity.status(HttpStatus.OK).body(this.saleService.cancelSale(sale_id));
  }


}
