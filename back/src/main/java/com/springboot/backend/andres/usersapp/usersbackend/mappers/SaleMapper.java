package com.springboot.backend.andres.usersapp.usersbackend.mappers;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.AdminSaleBasicInfoDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.AdminSaleDetailDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.SaleStatusDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Sale;
import com.springboot.backend.andres.usersapp.usersbackend.entities.SaleStatus;

public class SaleMapper {
  public static AdminSaleBasicInfoDTO mapSaleToAdminSaleBasicInfoDTO(Sale sale){
      AdminSaleBasicInfoDTO saleDTO = new AdminSaleBasicInfoDTO();

      saleDTO.setSale_id(sale.getSale_id());
      saleDTO.setDate(sale.getDate());
      saleDTO.setSaleStatus(mapSaleStatusToSaleStatusDTO(sale.getStatus()));
      saleDTO.setTotal(sale.getCart().getTotal());
      saleDTO.setItems(sale.getCart().getItems());
      saleDTO.setUser(UserMapper.mapUserToUserDTO(sale.getCart().getUser()));

      return  saleDTO;
  }

  public static AdminSaleDetailDTO mapSaleToSaleDetailDTO(Sale sale){
    AdminSaleDetailDTO saleDetailDTO = new AdminSaleDetailDTO();

    saleDetailDTO.setSale_id(sale.getSale_id());
    saleDetailDTO.setDate(sale.getDate());
    saleDetailDTO.setDirection(DirectionMapper.mapDirectionToDirectionDTO(sale.getDirection()));
    saleDetailDTO.setSaleStatus(mapSaleStatusToSaleStatusDTO(sale.getStatus()));
    saleDetailDTO.setTotal(sale.getCart().getTotal());
    saleDetailDTO.setItems(sale.getCart().getItems());
    saleDetailDTO.setUser(UserMapper.mapUserToUserDTO(sale.getCart().getUser()));

    saleDetailDTO.setProducts(sale.getCart().getOrderedProductList().stream().map(ProductMapper::mapOrderedProductToOrderedProductDetailDTO).toList());

    return  saleDetailDTO;
  }


  public static SaleStatusDTO mapSaleStatusToSaleStatusDTO(SaleStatus saleStatus){
    SaleStatusDTO saleStatusDTO = new SaleStatusDTO();
    if(saleStatus == null) {
      saleStatusDTO.setStatus_id(1L);
      saleStatusDTO.setName("Completed");
      saleStatusDTO.setDescription("Sale completed");
      return  saleStatusDTO;
    }
    saleStatusDTO.setStatus_id(saleStatus.getStatus_id());
    saleStatusDTO.setName(saleStatus.getName());
    saleStatusDTO.setDescription(saleStatus.getDescription());
    return  saleStatusDTO;
  }

}

