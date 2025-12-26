package com.example.springapp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.springapp.model.Category;

public interface CategoryService {
       public Category addC(Category c);
       public List<Category> getAllc();
       public Category getCbyId(Long id);
       public Category putCbyId(Long id,Category c);
       public boolean deletebyId(Long categoryId);
       public Page<Category> getByPage(int page,int size);
}
