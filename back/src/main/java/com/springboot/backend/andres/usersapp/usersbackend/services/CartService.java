package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Cart;
import com.springboot.backend.andres.usersapp.usersbackend.entities.FinalProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.OrderedProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Sale;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.ICartRepository;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IFinalProductRepository;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CartService implements ICartService{
  @Autowired
  private ICartRepository cartRepository;
  @Autowired
  private IOrderedProductService orderedProductService;
  @Autowired
  private UserService userService;
  @Autowired
  private IFinalProductService finalProductService;
  @Autowired
  private ISaleRepository saleRepository;

  @Override
  public Cart createCart(Long user_id) {
    Cart newCart = new Cart();
    newCart.setUser(this.userService.findById(user_id).get());
    return this.cartRepository.save(newCart);
  }

  @Override
  public Cart saveCart(Cart cart) {
    return this.cartRepository.save(cart);
  }

  @Override
  public Cart findById(Long cart_id) {
    return this.cartRepository.findById(cart_id).get();
  }

  @Override
  public Cart addProduct(OrderedProduct orderedProduct, Long cart_id) {
    Cart cartDB = this.cartRepository.findById(cart_id).get();
    OrderedProduct orderedProductDB = this.orderedProductService.createOrderedProduct(orderedProduct, cart_id);
    List<OrderedProduct> orderedProductList = cartDB.getOrderedProductList();
    orderedProductList.add(orderedProductDB);
    cartDB.setOrderedProductList(orderedProductList);
    cartDB.setTotal(this.calculateTotal(orderedProductList));
    cartDB.setItems(this.calculateTotalItems(orderedProductList));
    return this.cartRepository.save(cartDB);
  }

  @Override
  public Cart removeProduct(Long final_product_id, Long cart_id) {
    Cart cartDB = this.cartRepository.findById(cart_id).get();
    List<OrderedProduct> orderedProductList = cartDB.getOrderedProductList();
    OrderedProduct orderedProductRemove = new OrderedProduct();
    for(OrderedProduct orderedProduct: orderedProductList){
      if(Objects.equals(orderedProduct.getFinalProduct().getFinal_product_id(), final_product_id)){
        orderedProductRemove = orderedProduct;
      }
    }
    orderedProductList.remove(orderedProductRemove);
    this.orderedProductService.removeOrderedProduct(orderedProductRemove.getOrdered_product_id());
    cartDB.setOrderedProductList(orderedProductList);
    cartDB.setTotal(this.calculateTotal(orderedProductList));
    cartDB.setItems(this.calculateTotalItems(orderedProductList));
    return this.cartRepository.save(cartDB);
  }

  @Override
  public Cart UpdateProductQuantity(OrderedProduct orderedProduct, Long cart_id) {
    Cart cartDB = this.cartRepository.findById(cart_id).get();
    List<OrderedProduct> orderedProductListDB = cartDB.getOrderedProductList();
    for(OrderedProduct orderedProductDB: orderedProductListDB){
      if(Objects.equals(orderedProductDB.getFinalProduct().getFinal_product_id(), orderedProduct.getFinalProduct().getFinal_product_id())){
        this.orderedProductService.updateOrderedProduct(orderedProduct, orderedProductDB.getOrdered_product_id());
        orderedProductDB.setQuantity(orderedProduct.getQuantity());
      }
    }
    cartDB.setTotal(this.calculateTotal(orderedProductListDB));
    cartDB.setItems(this.calculateTotalItems(orderedProductListDB));
    return this.cartRepository.save(cartDB);
  }

  @Override
  public Cart cleanCart(Long cart_id) {
    Cart cartDB = this.cartRepository.findById(cart_id).get();
    List<OrderedProduct> orderedProductListDB = cartDB.getOrderedProductList();
    List<Long> ids = new ArrayList<>();
    for(OrderedProduct orderedProductDB: orderedProductListDB){
      System.out.println("Agregando ordered_product_id al listado: " + orderedProductDB.getOrdered_product_id());
      ids.add(orderedProductDB.getOrdered_product_id());
    }
    orderedProductListDB.clear();
    cartDB.setTotal(0);
    cartDB.setItems(0);
    cartDB = this.cartRepository.save(cartDB);
    for(Long id : ids){
      this.orderedProductService.removeOrderedProduct(id);
    }
    return cartDB;
  }


  //METODOS PARA OTROS SERVICES..
  @Override
  public Cart findBySaleId(Long sale_id) {
    List<Cart> cartList = (List<Cart>) this.cartRepository.findAll();
    List<Cart> cartListValid = new ArrayList<>();
    for (Cart cart: cartList){
      if(cart.getSale() != null){
        cartListValid.add(cart);
      }
    }
    for(Cart cart: cartListValid){
      if(Objects.equals(cart.getSale().getSale_id(), sale_id)){
        return cart;
      }
    }
    return null;
  }

  @Override
  public OrderedProduct findOrderedProduct(Long final_product_id, Long cart_id) {
    Cart cartDB = this.cartRepository.findById(cart_id).get();
    List<OrderedProduct> orderedProductList = cartDB.getOrderedProductList();
    for(OrderedProduct orderedProduct: orderedProductList){
      if(Objects.equals(orderedProduct.getFinalProduct().getFinal_product_id(), final_product_id)){
        return orderedProduct;
      }
    }
    return null;
  }

  @Override
  public Integer modifyCart(Long cart_id, List<OrderedProduct> orderedProductList){
    Cart cartDB = this.cartRepository.findById(cart_id).get();
    for(int i = 0 ; i < orderedProductList.size(); i++){
      cartDB.getOrderedProductList().get(i).setQuantity(orderedProductList.get(i).getQuantity());
    }
    cartDB.setTotal(this.calculateTotal(cartDB.getOrderedProductList()));
    cartDB.setItems(this.calculateTotalItems(cartDB.getOrderedProductList()));
    this.cartRepository.save(cartDB);
    return cartDB.getTotal();
  }



  //METODOS AUXILIARES
  private Integer calculateTotal(List<OrderedProduct> orderedProductList){
    int total = 0;
    for(OrderedProduct orderedProduct: orderedProductList){
      total += (orderedProduct.getQuantity() * this.finalProductService.findById(orderedProduct.getFinalProduct().getFinal_product_id()).getFinal_price());
    }
    return total;
  }

  private Integer calculateTotalItems(List<OrderedProduct> orderedProductList){
    int total = 0;
    for(OrderedProduct orderedProduct: orderedProductList){
      total += (orderedProduct.getQuantity());
    }
    return total;
  }

}

