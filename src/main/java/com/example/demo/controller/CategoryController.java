package com.example.demo.controller;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.service.CategoryService;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<CategoryEntity>> getAllCategories()throws Exception{
        System.out.println("GetMapping Working");
        List<CategoryEntity> categories=categoryService.getAll();
        return ResponseEntity.status(200).body(categories);
    }
    @PostMapping("/category")
    public ResponseEntity<?> createCategory(@RequestBody CategoryEntity category){
        System.out.println("Category post Mapping Starting ");
        if (category.getName()==null){
            System.out.println("Category if post Mapping Starting ");

            return ResponseEntity.status(400).body("please Enter a valid category");
        }else{
            System.out.println("Category else post Mapping Starting ");

            try {
                CategoryEntity newCategory=categoryService.createCategory(category);
                return ResponseEntity.status(201).body(newCategory);
            } catch (Exception e) {
                // TODO: handle exception
                return ResponseEntity.status(400).body("Not Susccessfull");
            }
        }

    }

    @PutMapping("/category/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody CategoryEntity category){
        System.out.println("Category Put MAppint Starting");
        if(category.getName()==null || id==null){
            System.out.println("Invalid input Date for category update");
            return ResponseEntity.status(400).body("please Enter valid Category Details");
        }else{
            try {
                CategoryEntity updatedCategory=categoryService.updateCategory(id, category);
                return ResponseEntity.status(200).body(updatedCategory);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("error during category update"+ e.getMessage());
                return ResponseEntity.status(400).body("Update Unseccessful");
            }
        }
    }




}
