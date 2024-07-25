package com.springboot.backend.andres.usersapp.usersbackend.services;

import com.springboot.backend.andres.usersapp.usersbackend.entities.*;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.IDirectionRepository;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.ISaleRepository;
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

  @Override
  public Sale findById(Long sale_id) {
    return this.saleRepository.findById(sale_id).get();
  }

  @Override
  public Page<Sale> findAll(Pageable pageable) {
    return this.saleRepository.findAll(pageable);
  }

  @Override
  public Sale createSale(Long cart_id, Long direction_id, Long user_id) {
    Cart cartDB = this.cartService.findById(cart_id);
    Direction directionDB = this.directionRepository.findById(direction_id).get();
    User userDB = this.userRepository.findById(user_id).get();
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
    this.finalProductService.modifyInventory(orderedProductToInventoryList);

    sale.setDate(LocalDateTime.now());
    sale.setDirection(directionDB);
    sale.setCart_id(cart_id);
    sale.setUser_id(user_id);
    sale.setStatus("Realizada");
    sale = this.saleRepository.save(sale);
    sale.setUsername(userDB.getUsername());
    cartDB.setSale(sale);
    this.cartService.saveCart(cartDB);
    return sale;
  }

  @Override
  public String modifySale(Long sale_id, List<OrderedProduct> orderedProductList) {
    Sale saleDB = this.saleRepository.findById(sale_id).get();
    Cart cartDB = this.cartService.findById(saleDB.getCart_id());
    Integer originalTotal = cartDB.getTotal();
    Integer originalItems = cartDB.getItems();
    Integer cartTotal;

    //modificar inventario (restituir)...OK
    List<OrderedProduct> orderedProductToInventoryList = new ArrayList<>();
    for(int i = 0; i < orderedProductList.size(); i++){
      Integer diferential = cartDB.getOrderedProductList().get(i).getQuantity() - orderedProductList.get(i).getQuantity();
      System.out.println("Diferential para indice i:" + i + " diferential: " + diferential);
      OrderedProduct orderedProductToInventory = new OrderedProduct();
      FinalProduct finalProductToInventory = new FinalProduct();
      finalProductToInventory.setFinal_product_id(orderedProductList.get(i).getFinalProduct().getFinal_product_id());
      orderedProductToInventory.setQuantity(diferential);
      orderedProductToInventory.setFinalProduct(finalProductToInventory);
      orderedProductToInventoryList.add(orderedProductToInventory);
    }
    this.finalProductService.modifyInventory(orderedProductToInventoryList);

    //modificar carrito
    cartTotal = this.cartService.modifyCart(saleDB.getCart_id(), orderedProductList);

    if(Objects.equals(cartTotal, 0)){
      saleDB.setStatus("Anulada");
      this.saleRepository.save(saleDB);
      return "Venta anulada con exito \n Productos devueltos: " + (originalItems - cartDB.getItems()) + "\n Dinero retornado: " + (originalTotal - cartDB.getTotal());
    }else{
      saleDB.setStatus("Modificada");
      this.saleRepository.save(saleDB);
      return "Venta modificada con exito \n Productos devueltos: " + (originalItems - cartDB.getItems()) + "\n Dinero retornado: " + (originalTotal - cartDB.getTotal());

    }

  }

  @Override
  public Page<Sale> filter(Pageable pageable, Long user_id, Date startDate, Date endDate, Integer startTotal, Integer endTotal, String status) {
    List<Sale> saleListDB = (List<Sale>) this.saleRepository.findAll();
    List<Sale> filtredByUser = new ArrayList<>();
    if(user_id > 0){
      for (Sale saleDB: saleListDB){
        if(Objects.equals(saleDB.getUser_id(), user_id)){
          filtredByUser.add(saleDB);
        }
      }
    }else {
      filtredByUser = saleListDB;
    }

    //Filtrando por total min y max
    List<Sale> filtredByTotal = new ArrayList<>();
    if(endTotal > 0){
      for(Sale saleDB: filtredByUser){
        Cart cartDB = this.cartService.findById(saleDB.getCart_id());
        if(cartDB.getTotal() != null) {
          if ((cartDB.getTotal() >= startTotal) && (cartDB.getTotal() <= endTotal)) {
            filtredByTotal.add(saleDB);
          }
        }
      }
    }else {
      filtredByTotal = filtredByUser;
    }

    //Filtrando por status
    List<Sale> filtredByStatus = new ArrayList<>();
    System.out.println("Que es esta mieda de status: " + status);
    if(Objects.equals(status, "Estado")){
      System.out.println("Deberia estar aqui filtando la wea de mierda");
      filtredByStatus = filtredByTotal;
    }else{
      System.out.println("Esta donde no deberia estar");
      for(Sale saleDB: filtredByTotal){
        if(Objects.equals(saleDB.getStatus(), status)){
          filtredByStatus.add(saleDB);
        }
      }
    }

    //Filtrando por fecha...... por implementar.
    return this.convertListToPage(filtredByStatus, pageable);
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


