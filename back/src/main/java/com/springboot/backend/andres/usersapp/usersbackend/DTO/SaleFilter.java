package com.springboot.backend.andres.usersapp.usersbackend.DTO;


import lombok.Data;

@Data
public class SaleFilter {
  private Long user_id;
  private Integer startTotal;
  private Integer endTotal;
  private Integer pageSize;
  private Integer page;
  private Long saleStatus_id;
}



//@GetMapping("/filter/{user_id}/{startTotal}/{endTotal}/{pageSize}/{page}/{status}")
