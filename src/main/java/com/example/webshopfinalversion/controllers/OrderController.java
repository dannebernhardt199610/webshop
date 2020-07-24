package com.example.webshopfinalversion.controllers;

import com.example.webshopfinalversion.domain.Orders;
import com.example.webshopfinalversion.domain.Product;
import com.example.webshopfinalversion.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;

    public OrderController() {
    }

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/orders")
    public List<Orders> findAllOrders() {
        return orderService.findAllOrders();
    }


    @RequestMapping(value = "/orderByUsername/{username}")
    public List<Orders> findOrderByUsername(@PathVariable String username) {
        return orderService.findOrderByUsername(username);
    }

    @RequestMapping(value = "/orderByID/{id}")
    public Orders findOrderByID(@PathVariable long id) {
        return orderService.findOrderByID(id);
    }


    @RequestMapping(value = "/lastCart/{username}")
    public List<Product> findLastCart(@PathVariable String username) {
        return orderService.findLastCartByUsername(username);
    }

}
