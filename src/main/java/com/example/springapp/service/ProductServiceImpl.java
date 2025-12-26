package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springapp.model.Product;
import com.example.springapp.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepo prepo;

    @Override
    public Product addP(Product p) {
        return prepo.save(p);
    }
    @Override
    public List<Product> getAllp(){
        return prepo.findAll();
    }
    @Override
    public Product getPbyId(Long id){
        return prepo.findById(id).orElse(null);
    }
    @Override
    public Product putPbyId(Long id,Product p){
        Product exists=prepo.findById(id).orElse(null);
        if(exists==null){
            return null;
        }
        exists.setProductName(p.getProductName());
        exists.setPrice(p.getPrice());
        exists.setCategory(p.getCategory());
        return prepo.save(exists);
    }
    @Override
    public Boolean deleteProduct(Long id){
        Product del=prepo.findById(id).orElse(null);
        if(del==null){
            return false;
        }
        prepo.deleteById(id);
        return true;
    }
    @Override
    public List<Product> getPbyName(String productName){
        return prepo.findByProductName(productName);
    }
    @Override
    public List<Product> getProductsByCategoryName(String categoryName){
        return prepo.getProductsByCategoryName(categoryName);
    }
            

    
}
