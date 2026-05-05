package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import com.springboot.backend.andres.usersapp.usersbackend.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;


public interface ISaleRepository extends JpaRepository<Sale, Long> {

  Page<Sale> findAll(Pageable pageable);

  @Query("SELECT s FROM Sale s " +
    "LEFT JOIN s.cart c " +
    "LEFT JOIN c.user u " +
    "LEFT JOIN s.status st " +
    "WHERE (:userId IS NULL OR u.id = :userId) " +
    "AND (:statusId IS NULL OR st.status_id = :statusId) " +
    "AND (:startTotal IS NULL OR COALESCE(c.total, 0) >= :startTotal) " +
    "AND (:endTotal IS NULL OR COALESCE(c.total, 0) <= :endTotal) " +
    "AND (:startDate IS NULL OR s.date >= :startDate) " +
    "AND (:endDate IS NULL OR s.date <= :endDate)")
  Page<Sale> filterSales(
    @Param("userId") Long userId,
    @Param("statusId") Long statusId,
    @Param("startTotal") Integer startTotal,
    @Param("endTotal") Integer endTotal,
    @Param("startDate") LocalDateTime startDate,
    @Param("endDate") LocalDateTime endDate,
    Pageable pageable
  );

}
