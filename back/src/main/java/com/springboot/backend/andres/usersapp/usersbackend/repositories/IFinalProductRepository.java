package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import com.springboot.backend.andres.usersapp.usersbackend.entities.FinalProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFinalProductRepository extends CrudRepository<FinalProduct, Long> {

  Page<FinalProduct> findAll(Pageable pageable);

  @Query(value = "SELECT fp FROM FinalProduct fp " +
    "JOIN fp.colorVariantProduct cv " +
    "JOIN cv.baseProduct p " +
    "JOIN p.brand b " +
    "JOIN p.categoryList c " +
    "WHERE (:brandId IS NULL OR b.id = :brandId) " +
    "AND (:colorId IS NULL OR cv.color.id = :colorId) " +
    "AND (:sizeId IS NULL OR fp.size.id = :sizeId) " +
    "AND (c.id IN :categoriesIds) " +
    "GROUP BY fp.id " +
    "HAVING COUNT(DISTINCT c.id) = :categorySize",
    countQuery = "SELECT COUNT(DISTINCT fp) FROM FinalProduct fp " +
      "JOIN fp.colorVariantProduct cv " +
      "JOIN cv.baseProduct p " +
      "JOIN p.categoryList c " +
      "WHERE (:brandId IS NULL OR p.brand.id = :brandId) " +
      "AND (:colorId IS NULL OR cv.color.id = :colorId) " +
      "AND (:sizeId IS NULL OR fp.size.id = :sizeId) " +
      "AND (c.id IN :categoriesIds) " +
      "GROUP BY fp.id " +
      "HAVING COUNT(DISTINCT c.id) = :categorySize")
  Page<FinalProduct> filterAdvanced(
    @Param("brandId") Long brandId,
    @Param("colorId") Long colorId,
    @Param("sizeId") Long sizeId,
    @Param("categoriesIds") List<Long> categoriesIds,
    @Param("categorySize") Long categorySize,
    Pageable pageable
  );

  @Query("SELECT fp FROM FinalProduct fp " +
    "JOIN fp.colorVariantProduct cv " +
    "JOIN cv.baseProduct p " +
    "WHERE (:brandId IS NULL OR p.brand.id = :brandId) " +
    "AND (:colorId IS NULL OR cv.color.id = :colorId) " +
    "AND (:sizeId IS NULL OR fp.size.id = :sizeId)")
  Page<FinalProduct> filterWithoutCategories(
    @Param("brandId") Long brandId,
    @Param("colorId") Long colorId,
    @Param("sizeId") Long sizeId,
    Pageable pageable
  );

}
