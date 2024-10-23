package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.repository.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryEntity createCategory(CategoryEntity category) throws Exception {
        // TODO Auto-generated method stub
        return categoryRepository.save(category);
    }

    @Override
    public List<CategoryEntity> getAll() throws Exception {
        // TODO Auto-generated method stub
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long id) throws Exception {
        // TODO Auto-generated method stub
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryEntity getCategoryById(Long id) throws Exception {
        // TODO Auto-generated method stub
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public CategoryEntity updateCategory(Long id, CategoryEntity category) throws Exception {
        // TODO Auto-generated method stub
        CategoryEntity existingCategory=categoryRepository.findById(id).orElse(null);
        if(existingCategory==null){
            return null;
        }else{
            existingCategory.setName(category.getName());
            return categoryRepository.save(existingCategory);
        }
    }

}
