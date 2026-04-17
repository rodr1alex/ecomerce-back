package com.springboot.backend.andres.usersapp.usersbackend.controllers;


import com.springboot.backend.andres.usersapp.usersbackend.DTO.BasicProductInfoDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.BrandDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.CreateBaseProductDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.ProductDetailDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProduct;
import com.springboot.backend.andres.usersapp.usersbackend.entities.BaseProductImage;
import com.springboot.backend.andres.usersapp.usersbackend.entities.Category;
import com.springboot.backend.andres.usersapp.usersbackend.mappers.ProductMapper;
import com.springboot.backend.andres.usersapp.usersbackend.services.IBaseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/base_products")
public class BaseProductController {
  @Autowired
  private IBaseProductService baseProductService;


  @GetMapping("")
  public List<BasicProductInfoDTO> findAll(){
    return  this.baseProductService.findAllProductsCommerce();
  }

//  @PostMapping("/create")
//  public BaseProduct create(@RequestBody BaseProduct newBaseProduct){
//    return this.baseProductService.create(newBaseProduct);
//  }

  @PostMapping("/create")
  public ResponseEntity<?> createNew(@RequestBody CreateBaseProductDTO createBaseProductDTO) {
    Long baseProductId = this.baseProductService.createNew(createBaseProductDTO);

    // Creamos un mapa para devolver un JSON limpio: { "id": X, "message": "..." }
    Map<String, Object> response = new HashMap<>();
    response.put("id", baseProductId);
    response.put("message", "Producto creado exitosamente");

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping("/{base_product_id}")
  public ProductDetailDTO findById(@PathVariable Long base_product_id){
    return ProductMapper.mapBaseProductToProductDetail(this.baseProductService.getProductDetail(base_product_id));
  }

  @GetMapping("/admin/{base_product_id}")
  public CreateBaseProductDTO findProductAdminDetailById(@PathVariable Long base_product_id){
    return  ProductMapper.mapBaseProductToCreateBaseProductDTO(this.baseProductService.getProductDetail(base_product_id));
  }

  @GetMapping("/featured_products/page/{page}")
  public Page<BaseProduct> getFeaturedProducts(@PathVariable Integer page){
    Pageable pageable = PageRequest.of(page, 40);
    return  this.baseProductService.getFeaturedProducts(pageable);
  }

  @PutMapping("/update/{base_product_id}")
  public BaseProduct update(@RequestBody BaseProduct baseProduct,@PathVariable Long base_product_id){
    return this.baseProductService.update(baseProduct, base_product_id);
  }

  @PutMapping("/update/add_image/{base_product_id}")
  public BaseProduct addImage(@RequestBody BaseProductImage baseProductImage,@PathVariable Long base_product_id){
    return this.baseProductService.addImage(baseProductImage, base_product_id);
  }

  @PutMapping("/update/remove_image/{base_product_id}")
  public BaseProduct removeImage(@RequestBody BaseProductImage baseProductImage,@PathVariable Long base_product_id){
    return this.baseProductService.removeImage(baseProductImage, base_product_id);
  }

  //METODOS DE FILTRADO

  //no usado
  @PostMapping("/filter/brand/{brand_id}/page/{page}")
  public Page<BasicProductInfoDTO> filterByBrand(@PathVariable Long brand_id, @PathVariable Integer page, @RequestBody List<Category> categoryList ){
    Pageable pageable = PageRequest.of(page, 4);
    return  this.baseProductService.filterByBrand(brand_id, pageable, categoryList);
  }

  //usado actualizado
  @PostMapping("/filter/category_list/page/{page}")
  public Page<BasicProductInfoDTO> filterByCategoryList(@RequestBody List<Long> categoriesIds, @PathVariable Integer page){
    Pageable pageable = PageRequest.of(page, 4);
    return this.baseProductService.filterByCategoryList(categoriesIds, pageable);
  }

  //usado actualizado
  @PostMapping("/filter/brand/get_list")
  public List<BrandDTO> getBrandList(@RequestBody List<Long> categoriesIds){
    return  this.baseProductService.getBrandList(categoriesIds);
  }
}
