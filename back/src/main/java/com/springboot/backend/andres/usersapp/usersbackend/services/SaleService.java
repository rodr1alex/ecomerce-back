package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.DTO.CartDTO;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.ProductReturned;
import com.springboot.backend.andres.usersapp.usersbackend.DTO.SaleStatusDTO;
import com.springboot.backend.andres.usersapp.usersbackend.entities.*;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IDirectionRepository;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.ISaleRepository;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.ISaleStatusRepository;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class SaleService implements ISaleService{
  @Autowired
  private ISaleRepository saleRepository;
  @Autowired
  private ICartService cartService;
  @Autowired
  private IFinalProductService finalProductService;
  @Autowired
  private IDirectionRepository directionRepository;
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ISaleStatusRepository saleStatusRepository;

  @Override
  public Sale findById(Long sale_id) {
    return this.saleRepository.findById(sale_id).get();
  }

  @Override
  public Page<Sale> findAll(Pageable pageable) {
    return this.saleRepository.findAll(pageable);
  }

  @Override
  public Sale createSale(CartDTO cartDTO) {
    Cart cartDB = this.cartService.createCart(cartDTO.getUser_id()); //this.cartService.findById(cart_id);
    cartDTO.getProducts().forEach(orderedProductDTO -> {
      this.cartService.addProduct(orderedProductDTO, cartDB.getCart_id());
    });
    Direction directionDB = this.directionRepository.findById(cartDTO.getDirection_id()).get();
    User userDB = this.userRepository.findById(cartDTO.getUser_id()).get();
    Sale sale = new Sale();
    for (OrderedProduct orderedProductDB: cartDB.getOrderedProductList()){       //Asignacion de originalquantity (la que no se modifica nunca)
      orderedProductDB.setOriginalquantity(orderedProductDB.getQuantity());
    }
    List<OrderedProduct> orderedProductToInventoryList = new ArrayList<>();        //Modificacion de inventario
    for(OrderedProduct orderedProductDB: cartDB.getOrderedProductList()){
      OrderedProduct orderedProductToInventory = new OrderedProduct();
      FinalProduct finalProductToInventory = new FinalProduct();
      finalProductToInventory.setFinal_product_id(orderedProductDB.getFinalProduct().getFinal_product_id());
      orderedProductToInventory.setQuantity(orderedProductDB.getQuantity() * -1);
      orderedProductToInventory.setFinalProduct(finalProductToInventory);
      orderedProductToInventoryList.add(orderedProductToInventory);
    }

    List<ProductReturned> productReturneds = orderedProductToInventoryList.stream().map(item ->{
      ProductReturned productReturned = new ProductReturned();
      productReturned.setFinal_product_id(item.getFinalProduct().getFinal_product_id());
      productReturned.setOrdered_product_id(item.getOrdered_product_id());
      productReturned.setQuantityToReturn(item.getQuantity());
      return  productReturned;
    }).toList();

    this.finalProductService.modifyInventory(productReturneds);

    sale.setDate(LocalDateTime.now());
    sale.setDirection(directionDB);
    sale.setCart(cartDB);
    //sale.setU(user_id);
    SaleStatus saleStatus = new SaleStatus();
    saleStatus.setStatus_id(1L);
    sale.setStatus(saleStatus);
    sale = this.saleRepository.save(sale);
   // sale.setUsername(userDB.getUsername());
    cartDB.setSale(sale);
    this.cartService.saveCart(cartDB);
    return sale;
  }

  @Override
  public String modifySale(Long sale_id, List<ProductReturned> productReturnedList) {

    //List<OrderedProduct> orderedProductList = new ArrayList<>();
    Sale saleDB = this.saleRepository.findById(sale_id).get();
    //Cart cartDB = this.cartService.findById(saleDB.getCart_id());
    Cart cartDB = this.cartService.findById(saleDB.getCart().getCart_id());
    Integer originalTotal = cartDB.getTotal();
    Integer originalItems = cartDB.getItems();
    Integer cartTotal;

    //modificar inventario (restituir)...OK
//    List<OrderedProduct> orderedProductToInventoryList = new ArrayList<>();
//    for(int i = 0; i < productReturnedList.size(); i++){
//      Integer diferential = productReturnedList.get(i).getQuantityToReturn(); //cartDB.getOrderedProductList().get(i).getQuantity() - productReturnedList.get(i).getQuantityToReturn();
//      System.out.println("Diferential para indice i:" + i + " diferential: " + diferential);
//      OrderedProduct orderedProductToInventory = new OrderedProduct();
//      FinalProduct finalProductToInventory = new FinalProduct();
//      finalProductToInventory.setFinal_product_id(productReturnedList.get(i).getFinal_product_id());
//      orderedProductToInventory.setQuantity(diferential);
//      orderedProductToInventory.setFinalProduct(finalProductToInventory);
//      orderedProductToInventoryList.add(orderedProductToInventory);
//    }
    this.finalProductService.modifyInventory(productReturnedList);

    //modificar carrito
    //cartTotal = this.cartService.modifyCart(saleDB.getCart_id(), orderedProductList);
    cartTotal = this.cartService.modifyCart(saleDB.getCart().getCart_id(), productReturnedList);

    if(Objects.equals(cartTotal, 0)){
     // saleDB.setStatus("Anulada");
      SaleStatus saleStatus = new SaleStatus();
      saleStatus.setStatus_id(3L);
      saleDB.setStatus(saleStatus);
      this.saleRepository.save(saleDB);
      return "Venta anulada con exito \n Productos devueltos: " + (originalItems - cartDB.getItems()) + "\n Dinero retornado: " + (originalTotal - cartDB.getTotal());
    }else{
      //saleDB.setStatus("Modificada");
      SaleStatus saleStatus = new SaleStatus();
      saleStatus.setStatus_id(2L);
      saleDB.setStatus(saleStatus);
      this.saleRepository.save(saleDB);
      return "Venta modificada con exito \n Productos devueltos: " + (originalItems - cartDB.getItems()) + "\n Dinero retornado: " + (originalTotal - cartDB.getTotal());

    }

  }

  @Override
  public String cancelSale(Long sale_id) {
    Sale saleDB = this.saleRepository.findById(sale_id).get();
    Cart cartDB = this.cartService.findById(saleDB.getCart().getCart_id());

    List<ProductReturned> productReturnedList = cartDB.getOrderedProductList().stream()
      .map(item -> {
        ProductReturned productReturned = new ProductReturned();
        productReturned.setFinal_product_id(item.getFinalProduct().getFinal_product_id());
        productReturned.setOrdered_product_id(item.getOrdered_product_id());
        productReturned.setQuantityToReturn(item.getQuantity());
        System.out.println("Producto a retornar completamente: " + productReturned.toString());
        return  productReturned;
      }).toList();
    return modifySale(sale_id, productReturnedList);
  }

  @Override
  public Page<Sale> filter(Pageable pageable, Long user_id, Date startDate, Date endDate, Integer startTotal, Integer endTotal, Long status_id) {
    List<Sale> saleListDB = (List<Sale>) this.saleRepository.findAll();
    List<Sale> filtredByUser = new ArrayList<>();
    if(user_id != null){
      for (Sale saleDB: saleListDB){
        //if(Objects.equals(saleDB.getUser_id(), user_id))
        if(Objects.equals(saleDB.getCart().getUser().getId(), user_id)){
          filtredByUser.add(saleDB);
        }
      }
    }else {
      filtredByUser = saleListDB;
    }

    //Filtrando por total min y max
    List<Sale> filtredByTotal = new ArrayList<>();
    if(endTotal != null && startTotal != null){
      for(Sale saleDB: filtredByUser){
        //Cart cartDB = this.cartService.findById(saleDB.getCart_id());
        Cart cartDB = this.cartService.findById(1L);
        if(cartDB.getTotal() != null) {
          if ((cartDB.getTotal() >= startTotal) && (cartDB.getTotal() <= endTotal)) {
            filtredByTotal.add(saleDB);
          }
        }
      }
    }else {
      filtredByTotal = filtredByUser;
    }


    List<Sale> filtredByStatus = new ArrayList<>();
    if(status_id != null){
      for(Sale saleDB: filtredByTotal){
        if(Objects.equals(saleDB.getStatus().getStatus_id(), status_id)){
          filtredByStatus.add(saleDB);
        }
      }
    }else {
      filtredByStatus = filtredByTotal;
    }


    //Filtrando por status

//    System.out.println("Que es esta mieda de status: " + status);
//    if(Objects.equals(status, "Estado")){
//      System.out.println("Deberia estar aqui filtando la wea de mierda");
//      filtredByStatus = filtredByTotal;
//    }else{
//      System.out.println("Esta donde no deberia estar");
//      for(Sale saleDB: filtredByTotal){
//        if(Objects.equals(saleDB.getStatus().getStatus_id(), status_id)){
//          filtredByStatus.add(saleDB);
//        }
//      }
//    }

    //Filtrando por fecha...... por implementar.
    return this.convertListToPage(filtredByStatus, pageable);
  }

  @Override
  public List<SaleStatus> getAllSaleStatus() {
    return (List<SaleStatus>) saleStatusRepository.findAll();
  }


  //Metodos auxiliares
  public  Page<Sale> convertListToPage(List<Sale> list, Pageable pageable) {
    if (list == null || list.isEmpty()) {
      return new PageImpl<>(List.of(), pageable, 0);
    }

    int start = (int) pageable.getOffset();
    int end = Math.min((start + pageable.getPageSize()), list.size());

    if (start > end) {
      return new PageImpl<>(List.of(), pageable, list.size());
    }

    List<Sale> subList = list.subList(start, end);
    return new PageImpl<>(subList, pageable, list.size());
  }



}
















/*
  @Override
  public Cart returnProduct(OrderedProduct orderedProduct, Long sale_id) {
    Sale saleDB = this.saleRepository.findById(sale_id).get();
    Cart cartDB = this.cartService.findBySaleId(sale_id);
    OrderedProduct orderedProductOriginal = this.cartService.findOrderedProduct(orderedProduct.getFinalProduct().getFinal_product_id(), cartDB.getCart_id());
    Integer differential =orderedProduct.getQuantity() - orderedProductOriginal.getQuantity();
    this.cartService.UpdateProductQuantity(orderedProduct,cartDB.getCart_id()); //MODIFICAR CARRITO
    orderedProduct.setQuantity(differential);
    List<OrderedProduct> orderedProductList = new ArrayList<>();
    orderedProductList.add(orderedProduct);
    this.finalProductService.modifyInventory(orderedProductList); // metodo modifyInventory cambio... reviar si se requiere este metodo
    this.saleRepository.save(saleDB);
    return cartDB;
  }

  @Override
  public Cart removeProduct(Long final_product_id, Long sale_id) {
    Sale saleDB = this.saleRepository.findById(sale_id).get();
    Cart cartDB = this.cartService.findBySaleId(sale_id);
    OrderedProduct orderedProductOriginal = this.cartService.findOrderedProduct(final_product_id, cartDB.getCart_id());
    OrderedProduct orderedProductCopy = new OrderedProduct();
    orderedProductCopy.setQuantity(orderedProductOriginal.getQuantity() * -1);
    orderedProductCopy.setFinalProduct(orderedProductOriginal.getFinalProduct());
    this.cartService.removeProduct(final_product_id, cartDB.getCart_id());
    List<OrderedProduct> orderedProductList = new ArrayList<>();
    orderedProductList.add(orderedProductCopy);
    this.finalProductService.modifyInventory(orderedProductList); //metodo modifyInventory cambio... reviar si se requiere este metodo
    saleDB.setStatus("Modificada");
    this.saleRepository.save(saleDB);
    return cartDB;
  }

  @Override
  public void cancelSale(Long sale_id) {
    Sale saleDB = this.saleRepository.findById(sale_id).get();
    Cart cartDB = this.cartService.findBySaleId(sale_id);
    List<OrderedProduct> orderedProductListDB = cartDB.getOrderedProductList();
    List<OrderedProduct> orderedProductListCopy = new ArrayList<>();
    for(OrderedProduct orderedProductDB: orderedProductListDB){
      OrderedProduct orderedProductCopy = new OrderedProduct();
      orderedProductCopy.setQuantity(orderedProductDB.getQuantity() * -1);
      orderedProductCopy.setFinalProduct(orderedProductDB.getFinalProduct());
      orderedProductListCopy.add(orderedProductCopy);
    }
    this.cartService.cleanCart(cartDB.getCart_id());
    this.finalProductService.modifyInventory(orderedProductListCopy); //metodo modifyInventory cambio... reviar si se requiere este metodo
    saleDB.setStatus("Anulada");
    this.saleRepository.save(saleDB);
  }*/


