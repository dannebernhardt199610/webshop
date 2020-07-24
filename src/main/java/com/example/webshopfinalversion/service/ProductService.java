package com.example.webshopfinalversion.service;

import com.example.webshopfinalversion.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllProducts();


    Product findByName(String productName);


    List<Product> findByNameContaining(String containing);

}