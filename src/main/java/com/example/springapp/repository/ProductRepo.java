package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long>{
    public List<Product> findByProductName(String productName);

    @Query("select p from Product p where p.category.categoryName= :categoryName")
    public List<Product> getProductsByCategoryName(@Param("categoryName") String categoryName);


    
}
