package com.springboot.backend.andres.usersapp.usersbackend.mappers;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.CartDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.SaleDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.SaleDetailDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.SaleStatusDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Cart;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Sale;
import com.springboot.backend.andres.usersapp.usersbackend.entities.SaleStatus;

public class SaleMapper {
  public static SaleDTO mapSaleToSaleDTO(Sale sale){
      SaleDTO saleDTO = new SaleDTO();

      saleDTO.setSale_id(sale.getSale_id());
      saleDTO.setDate(sale.getDate());
      saleDTO.setDirection(DirectionMapper.mapDirectionToDirectioDTO(sale.getDirection()));

      saleDTO.setSaleStatus(mapSaleStatusToSaleStatusDTO(sale.getStatus()));
      //SaleStatusDTO saleStatusDTO = new SaleStatusDTO();
      //saleDTO.setSaleStatus(saleStatusDTO);

      saleDTO.setCart(CartMapper.mapCartToCartDTO(sale.getCart()));
      saleDTO.setTotal(sale.getCart().getTotal());
      saleDTO.setItems(sale.getCart().getItems());
      saleDTO.setUser(UserMapper.mapUserToUserDTO(sale.getCart().getUser()));

      return  saleDTO;
  }

  public static SaleDetailDTO mapSaleToSaleDetailDTO(Sale sale){
    SaleDetailDTO saleDetailDTO = new SaleDetailDTO();

    saleDetailDTO.setSale_id(sale.getSale_id());
    saleDetailDTO.setDate(sale.getDate());
    saleDetailDTO.setDirection(DirectionMapper.mapDirectionToDirectioDTO(sale.getDirection()));
    saleDetailDTO.setSaleStatus(mapSaleStatusToSaleStatusDTO(sale.getStatus()));
    saleDetailDTO.setTotal(sale.getCart().getTotal());
    saleDetailDTO.setItems(sale.getCart().getItems());
    saleDetailDTO.setUser(UserMapper.mapUserToUserDTO(sale.getCart().getUser()));

    saleDetailDTO.setProducts(sale.getCart().getOrderedProductList().stream().map(ProductMapper::mapOrderedProductToOrderedProductDetailDTO).toList());

    return  saleDetailDTO;
  }


  public static SaleStatusDTO mapSaleStatusToSaleStatusDTO(SaleStatus saleStatus){
    SaleStatusDTO saleStatusDTO = new SaleStatusDTO();
    saleStatusDTO.setStatus_id(saleStatus.getStatus_id());
    saleStatusDTO.setName(saleStatus.getName());
    saleStatusDTO.setDescription(saleStatus.getDescription());
    return  saleStatusDTO;
  }
}

//SaleDetailDTO
