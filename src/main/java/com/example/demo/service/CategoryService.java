package com.example.demo.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CategoryEntity;
@Service
public interface CategoryService {
    CategoryEntity createCategory(CategoryEntity category)throws Exception;
    List<CategoryEntity> getAll()throws Exception;
    void deleteCategory(Long id)throws Exception;
    CategoryEntity getCategoryById(Long id)throws Exception;
    CategoryEntity updateCategory(Long id,CategoryEntity category) throws Exception;

}
