package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Product;

public interface ProductService {
     public Product addP(Product p);
     public List<Product> getAllp();
     public Product getPbyId(Long id);
     public Product putPbyId(Long id,Product p);
     public Boolean deleteProduct(Long id);
     public List<Product> getPbyName(String productName);
     public List<Product> getProductsByCategoryName(String categoryName);
}
