package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Cart;
import com.springboot.backend.andres.usersapp.usersbackend.entities.OrderedProduct;
import com.springboot.backend.andres.usersapp.usersbackend.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/cart")
public class CartController {
  @Autowired
  private ICartService cartService;

  @PostMapping("/create/{user_id}")
  public Cart createCart(@PathVariable Long user_id){
    return this.cartService.createCart(user_id);
  }

  @GetMapping("/{cart_id}")
  public Cart findById(@PathVariable Long cart_id){
    return  this.cartService.findById(cart_id);
  }

  @GetMapping("")
  public List<Cart> findAll(){
    return this.cartService.findAll();
  }

  @PutMapping("/update/add_product/{cart_id}")
  public Cart addProduct(@RequestBody OrderedProduct orderedProduct,@PathVariable Long cart_id){
    return this.cartService.addProduct(orderedProduct, cart_id);
  }

  @PutMapping("/update/remove_product/{cart_id}/{final_product_id}")
  public Cart removeProduct(@PathVariable Long final_product_id,@PathVariable Long cart_id){
    return this.cartService.removeProduct(final_product_id, cart_id);
  }

  @PutMapping("/update/quantity_product/{cart_id}")
  public Cart updateProductQuantity(@RequestBody OrderedProduct orderedProduct,@PathVariable Long cart_id){
    return  this.cartService.UpdateProductQuantity(orderedProduct, cart_id);
  }

  @PutMapping("/update/clean/{cart_id}")
  public Cart cleanCart(@PathVariable Long cart_id){
    return this.cartService.cleanCart(cart_id);
  }
}
