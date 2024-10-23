package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductReqDto;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/product")
    public ResponseEntity<List<ProductEntity>> getAllProducts(){
        System.out.println("Starting get Map");
        try {
        System.out.println("Success");   
        List<ProductEntity>  products=productService.getAll();
        return ResponseEntity.status(200).body(products);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(400).body(null);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductReqDto productDto){
        System.out.println("Post Mapping Starting");
        try {
            System.out.println("Success");
            ProductEntity newProduct=new ProductEntity();
            newProduct.setName(productDto.getName());
            newProduct.setExpDate(productDto.getExpDate());
            newProduct.setQty(productDto.getQty());
            newProduct.setUnitPrice(productDto.getUnitPrice());
            CategoryEntity category=categoryService.getCategoryById(productDto.getCatId());
            newProduct.setCategory(category);
            ProductEntity createdProduct=productService.createProduct(newProduct);
            return ResponseEntity.status(200).body(createdProduct);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Catch working");
            return ResponseEntity.status(400).body(null);
        }

    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id)throws Exception{
        productService.deleteProduct(id);
        

    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long id, @RequestBody ProductReqDto productDto){
        System.out.println("put mapping starting");
        try {
            System.out.println("Success");
            ProductEntity newProduct=new ProductEntity();
            newProduct.setName(productDto.getName());
            newProduct.setExpDate(productDto.getExpDate());
            newProduct.setQty(productDto.getQty());
            newProduct.setUnitPrice(productDto.getUnitPrice());
            CategoryEntity category=categoryService.getCategoryById(productDto.getCatId());
            if (category!=null){
                newProduct.setCategory(category);
                ProductEntity createdProduct=productService.updateProduct(id,newProduct);
                return ResponseEntity.status(200).body(createdProduct);

            }else{
                return ResponseEntity.status(400).body(null);
            }
           
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(400).body(null);
        }

    }
 

    
}
