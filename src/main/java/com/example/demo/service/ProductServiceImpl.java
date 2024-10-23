package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity createProduct(ProductEntity product) throws Exception {
        // TODO Auto-generated method stub
        return productRepository.save(product);
    }

    @Override
    public ProductEntity getProductById(Long id) throws Exception {
        // TODO Auto-generated method stub
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public ProductEntity updateProduct(Long id, ProductEntity product) throws Exception {
        // TODO Auto-generated method stub
        ProductEntity existingProduct=productRepository.findById(id).orElse(null);
        if(existingProduct!=null){
            existingProduct.setName(product.getName());
            existingProduct.setExpDate(product.getExpDate());
            existingProduct.setQty(product.getQty());
            existingProduct.setUnitPrice(product.getUnitPrice());
            return productRepository.save(existingProduct);
        }else{
            return null;
        }
    }

    @Override
    public void deleteProduct(Long id) throws Exception {
        // TODO Auto-generated method stub
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductEntity> getAll() throws Exception {
        // TODO Auto-generated method stub
        return productRepository.findAll();
    }

}
