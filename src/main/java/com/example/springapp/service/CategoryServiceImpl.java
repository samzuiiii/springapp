package com.example.springapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Category;
import com.example.springapp.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{
        @Autowired
        private CategoryRepo crepo;
        
        @Override
        public Category addC(Category c){
            return crepo.save(c);
        }
        @Override
        public List<Category> getAllc(){
            return crepo.findAll();
        }
        @Override
        public Category getCbyId(Long id){
            return crepo.findById(id).orElse(null);
        }
        @Override
        public Category putCbyId(Long id,Category c){
            Category exists=crepo.findById(id).orElse(null);
            if(exists==null){
                return null;
            }
            exists.setCategoryName(c.getCategoryName());
            return crepo.save(exists);
        }
        @Override
        public boolean deletebyId(Long categoryId){
            Category exists=crepo.findById(categoryId).orElse(null);
            if(exists==null){
                return false;
            }
            crepo.deleteById(categoryId);
            return true;
        }
        @Override
        public Page<Category> getByPage(int page,int size){
            Pageable pageable=PageRequest.of(page,size);
            return crepo.findAll(pageable);
        }
   
}

