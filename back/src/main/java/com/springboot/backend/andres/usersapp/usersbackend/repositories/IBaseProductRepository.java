package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.BrandDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBaseProductRepository extends CrudRepository<BaseProduct, Long> {
  //Page<User> findAll(Pageable pageable);

  Page<BaseProduct> findAll(Pageable pageable);
  //Page<BaseProduct> findByCategories_CategoryIdIn(List<Long> categoriesIds, Pageable pageable);

  @Query("SELECT p FROM BaseProduct p " +
    "JOIN p.categoryList c " +
    "WHERE c.category_id IN :categoriesIds " +
    "GROUP BY p.id " +
    "HAVING COUNT(DISTINCT c.category_id) = :expectedSize")
  Page<BaseProduct> findByAllCategories(
    @Param("categoriesIds") List<Long> categoriesIds,
    @Param("expectedSize") Long expectedSize,
    Pageable pageable
  );

  @Query("SELECT DISTINCT new com.springboot.backend.andres.usersapp.usersbackend.DTO.BrandDTO(b.brand_id, b.name) " +
    "FROM BaseProduct p " +
    "JOIN p.brand b " +
    "JOIN p.categoryList c " +
    "WHERE c.category_id IN :categoriesIds " +
    "GROUP BY p.base_product_id, b.brand_id, b.name " +
    "HAVING COUNT(DISTINCT c.category_id) = :size")
  List<BrandDTO> findBrandsWithAllCategories(
    @Param("categoriesIds") List<Long> categoriesIds,
    @Param("size") Long size
  );
}
