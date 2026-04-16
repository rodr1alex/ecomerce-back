package com.springboot.backend.andres.usersapp.usersbackend.mappers;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.CartDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.OrderedProductDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.UserDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Cart;
import com.springboot.backend.andres.usersapp.usersbackend.entities.OrderedProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.User;

public class CartMapper {

  public static CartDTO mapCartToCartDTO(Cart cart){
    CartDTO cartDTO = new CartDTO();

    cartDTO.setUser_id(cart.getUser().getId());
    if(cart.getSale() != null){
      cartDTO.setDirection_id(cart.getSale().getDirection().getDirection_id());
    }

    cartDTO.setProducts(cart.getOrderedProductList().stream().map(CartMapper::mapOrderedProductToOrderedProductDTO).toList());

    return  cartDTO;
  }

  public static OrderedProductDTO mapOrderedProductToOrderedProductDTO(OrderedProduct orderedProduct){
    OrderedProductDTO orderedProductDTO = new OrderedProductDTO();

    orderedProductDTO.setFinal_product_id(orderedProduct.getFinalProduct().getFinal_product_id());
    orderedProductDTO.setQuantity(orderedProduct.getQuantity());
    return  orderedProductDTO;
  }
}
