package com.example.webshopfinalversion.controllers;

import com.example.webshopfinalversion.domain.Product;
import com.example.webshopfinalversion.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController

public class ProductController {

    private ProductService productService;

    public ProductController() {
    }

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping(value = "/products")
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }



    @RequestMapping(value = "/searchProductContaining/{containing}")
    public List<Product> findByNameContaining(@PathVariable String containing) {
        return productService.findByNameContaining(containing);
    }

    @RequestMapping(value = "/productName/{productName}")
    public Product findProductByName(@PathVariable String productName) {
        return productService.findByName(productName);
    }
}