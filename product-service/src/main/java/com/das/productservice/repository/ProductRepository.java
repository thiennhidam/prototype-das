package com.das.productservice.repository;

import com.das.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findById(int id);
    List<Product> findAllByStatus(int status);
}
