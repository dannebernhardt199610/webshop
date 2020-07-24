package com.example.webshopfinalversion.repository;

import com.example.webshopfinalversion.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByNameIgnoreCase(String productName);

    List<Product> findByNameContainingIgnoreCase(String containing);
}
