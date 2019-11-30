package com.das.productservice.service;

import com.das.productservice.common.Const;
import com.das.productservice.model.Product;
import com.das.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ProductService {

    @PersistenceContext
    private EntityManager em;

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(int id){
        return productRepository.findById(id);
    }

    public List<Product> getActiveProductList(){
        return productRepository.findAllByStatus(Const.PRODUCT_STATUS.ACTIVE.value);
    }
}
