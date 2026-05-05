package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.CartForPaymentDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.ProductReturned;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Cart;
import com.springboot.backend.andres.usersapp.usersbackend.entities.OrderedProduct;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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


  @Override
  public Cart createCart(CartForPaymentDTO cartDTO) {
    Cart newCart = new Cart();
    newCart.setUser(this.userService.findById(cartDTO.getUserId()).get());
    Cart cartDB = this.cartRepository.save(newCart);

    List<OrderedProduct> orderedProductList = cartDTO.getProducts().stream()
      .map(orderedProductDTO -> this.orderedProductService.createOrderedProduct(orderedProductDTO, cartDB.getId()))
      .collect(Collectors.toList());

    cartDB.setOrderedProductList(orderedProductList);
    cartDB.setTotal(this.calculateTotal(orderedProductList));
    cartDB.setItems(this.calculateTotalItems(orderedProductList));
    return this.cartRepository.save(cartDB);
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
  public List<Cart> findAll() {
    return (List<Cart>) this.cartRepository.findAll();
  }

  @Override
  public Cart modifyCart(Long cart_id, List<ProductReturned> productReturneds){
    Cart cartDB = this.cartRepository.findById(cart_id).get();

    productReturneds.forEach(productReturned -> {
      cartDB.getOrderedProductList().forEach(orderedProduct -> {
        if(Objects.equals(orderedProduct.getFinalProduct().getId(), productReturned.getFinalProductId())){
          orderedProduct.setQuantity(orderedProduct.getQuantity() - productReturned.getQuantityToReturn());
        }
      });
    });

    cartDB.setTotal(this.calculateTotal(cartDB.getOrderedProductList()));
    cartDB.setItems(this.calculateTotalItems(cartDB.getOrderedProductList()));
    return this.cartRepository.save(cartDB);
  }



  //METODOS AUXILIARES
  private Integer calculateTotal(List<OrderedProduct> orderedProductList){
    int total = 0;
    for(OrderedProduct orderedProduct: orderedProductList){
      total += (orderedProduct.getQuantity() * this.finalProductService.findById(orderedProduct.getFinalProduct().getId()).getFinalPrice());
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

