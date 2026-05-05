package com.springboot.backend.andres.usersapp.usersbackend.mappers;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.CartForPaymentDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.OrderedProductDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Cart;
import com.springboot.backend.andres.usersapp.usersbackend.entities.OrderedProduct;

public class CartMapper {

//  public static CartForPaymentDTO mapCartToCartForPaymentDTO(Cart cart){
//    CartForPaymentDTO cartDTO = new CartForPaymentDTO();
//
//    cartDTO.setUser_id(cart.getUser().getId());
//    if(cart.getSale() != null){
//      cartDTO.setDirection_id(cart.getSale().getDirection().getDirection_id());
//    }
//
//    cartDTO.setProducts(cart.getOrderedProductList().stream().map(CartMapper::mapOrderedProductToOrderedProductDTO).toList());
//
//    return  cartDTO;
//  }

  public static OrderedProductDTO mapOrderedProductToOrderedProductDTO(OrderedProduct orderedProduct){
    OrderedProductDTO orderedProductDTO = new OrderedProductDTO();

    orderedProductDTO.setFinalProductId(orderedProduct.getFinalProduct().getId());
    orderedProductDTO.setQuantity(orderedProduct.getQuantity());
    return  orderedProductDTO;
  }

}
