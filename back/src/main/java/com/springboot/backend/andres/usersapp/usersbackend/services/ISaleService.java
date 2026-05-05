package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.CartForPaymentDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.ProductReturned;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Sale;
import com.springboot.backend.andres.usersapp.usersbackend.entities.SaleStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ISaleService {
  public Sale findById(Long sale_id);
  public Sale createSale(CartForPaymentDTO cart);
  public Sale modifySale(Long sale_id, List<ProductReturned> productReturneds);
  public Sale cancelSale(Long sale_id);
  public Page<Sale> filter(Pageable pageable, Long user_id, LocalDateTime startDate, LocalDateTime endDate, Integer startTotal, Integer endTotal, Long status_id);
  public List<SaleStatus> getAllSaleStatus();
}
