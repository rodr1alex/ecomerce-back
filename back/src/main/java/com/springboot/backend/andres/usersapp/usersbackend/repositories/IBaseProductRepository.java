package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.BrandDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBaseProductRepository extends CrudRepository<BaseProduct, Long> {

  Page<BaseProduct> findAll(Pageable pageable);

  @Query("SELECT b " +
    "FROM BaseProduct p " +
    "JOIN p.brand b " +
    "JOIN p.categoryList c " +
    "WHERE c.id IN :categoriesIds " +
    "GROUP BY b.id, b.name " +
    "HAVING COUNT(DISTINCT c.id) = :size")
  List<Brand> findBrandsWithAllCategories(
    @Param("categoriesIds") List<Long> categoriesIds,
    @Param("size") Long size
  );

  @Query("SELECT p " +
    "FROM BaseProduct p " +
    "JOIN p.categoryList c " +
    "JOIN p.brand b " +
    "WHERE (:brandId IS NULL OR b.id = :brandId) " +
    "AND (c.id IN :categoriesIds) " +
    "GROUP BY p.id " +
    "HAVING COUNT(DISTINCT c.id) = :size")
  Page<BaseProduct> findByBrandAndAllCategories(
    @Param("brandId") Long brandId,
    @Param("categoriesIds") List<Long> categoriesIds,
    @Param("size") Long size,
    Pageable pageable
  );

  @Query("SELECT p FROM BaseProduct p JOIN p.brand b WHERE b.id = :brandId")
  Page<BaseProduct> findByBrandId(@Param("brandId") Long brandId, Pageable pageable);


}
