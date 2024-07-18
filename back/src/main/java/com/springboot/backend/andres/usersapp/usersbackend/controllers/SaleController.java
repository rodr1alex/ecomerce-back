package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Cart;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Direction;
import com.springboot.backend.andres.usersapp.usersbackend.entities.OrderedProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Sale;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IFinalProductRepository;
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
  public Sale findById(@PathVariable Long sale_id){
    return this.saleService.findById(sale_id);
  }

  @GetMapping("/{pageSize}/{page}")
  private Page<Sale> findAll(@PathVariable Integer pageSize,@PathVariable Integer page){
    Pageable pageable = PageRequest.of(page, pageSize);
    return this.saleService.findAll(pageable);
  }

  @GetMapping("/filter/{user_id}/{startTotal}/{endTotal}/{pageSize}/{page}")
  private Page<Sale> filter(@PathVariable Long user_id,@PathVariable Integer startTotal,@PathVariable Integer endTotal,@PathVariable Integer pageSize,@PathVariable Integer page){
    Date startDate = new Date();
    Date endDate = new Date();
    Pageable pageable = PageRequest.of(page, pageSize);
    return this.saleService.filter(pageable, user_id, startDate, endDate, startTotal, endTotal);
  }

  @PostMapping("/create/{cart_id}/{user_id}")
  private ResponseEntity<?> createSale(@PathVariable Long cart_id,@RequestBody Direction direction,@PathVariable Long user_id){
    Cart cartDB = this.cartService.findById(cart_id);
    if(this.finalProductService.verifyInventory(cartDB.getOrderedProductList()).isEmpty()){
        return ResponseEntity.status(HttpStatus.OK).body(this.saleService.createSale(cart_id, direction.getDirection_id(),user_id));
    }
    return ResponseEntity.status(HttpStatus.CONFLICT)
      .body(this.finalProductService.verifyInventory(cartDB.getOrderedProductList()));
  }

  @PutMapping("/modify/{sale_id}")
  private void modify(@PathVariable Long sale_id,@RequestBody List<OrderedProduct> orderedProductList){
     this.saleService.modifySale(sale_id, orderedProductList);
  }


}
