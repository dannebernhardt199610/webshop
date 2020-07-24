package com.example.webshopfinalversion.service;

import com.example.webshopfinalversion.domain.Orders;
import com.example.webshopfinalversion.domain.Product;

import java.util.List;

public interface OrderService {

    List<Orders> findAllOrders();

    List <Orders> findOrderByUsername(String username);

    Orders findOrderByID(long id);

    List <Product> findLastCartByUsername (String username);

}
