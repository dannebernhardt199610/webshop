package com.example.webshopfinalversion.service;


import com.example.webshopfinalversion.domain.Product;
import com.example.webshopfinalversion.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    public ProductServiceImpl() {}

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findByName(String productName) {
        Product result = productRepository.findByNameIgnoreCase(productName);
        log.info("findByProductByName " + result);
        return result;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByNameContaining(String containing) {
        return productRepository.findByNameContainingIgnoreCase(containing);
    }
}