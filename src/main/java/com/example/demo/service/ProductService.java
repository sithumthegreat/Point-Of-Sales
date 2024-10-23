package com.example.demo.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductEntity;

@Service
public interface ProductService {
    ProductEntity createProduct(ProductEntity product)throws Exception;
    ProductEntity getProductById(Long id)throws Exception;
    ProductEntity updateProduct(Long id,ProductEntity product)throws Exception;
    void deleteProduct(Long id)throws Exception;
    List<ProductEntity> getAll()throws Exception;

}
