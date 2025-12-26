package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springapp.model.Product;
import com.example.springapp.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
        @Autowired
        private ProductService pser;

        @PostMapping
        public ResponseEntity<Product> addP(@RequestBody Product p){
            Product saved=pser.addP(p);
            return new ResponseEntity<>(saved,HttpStatus.CREATED);
        }
        @GetMapping
        public ResponseEntity<List<Product>> getAllp(){
            List<Product> saved=pser.getAllp();
            return new ResponseEntity<>(saved,HttpStatus.OK);
        }
        @GetMapping("/{id}")
        public ResponseEntity<Product> getPbyId(@PathVariable Long id){
            Product pid=pser.getPbyId(id);
            return new ResponseEntity<>(pid,HttpStatus.OK);
        }
        @PutMapping("/{id}")
        public ResponseEntity<Product> putPbyId(@PathVariable Long id,@RequestBody Product p){
           Product pid=pser.putPbyId(id,p);
           return new ResponseEntity<>(pid,HttpStatus.OK);
        
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<Boolean> deleteProduct(@PathVariable Long id){
            Boolean pname=pser.deleteProduct(id);
            if(!pname){
                   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pname,HttpStatus.OK);
        }

        @GetMapping("/name/{productName}")
        public ResponseEntity<?> getPbyName(@PathVariable String productName){
            List<Product> pname=pser.getPbyName(productName);
            if(pname.isEmpty()){
                   return new ResponseEntity<>("No products found with name: " + productName,HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(pname,HttpStatus.OK);
        }
        @GetMapping("/category/{categoryName}")
        public ResponseEntity<List<Product>> getProductsByCategoryName(@PathVariable String categoryName){
            List<Product> list=pser.getProductsByCategoryName(categoryName);
            return new ResponseEntity<>(list,HttpStatus.OK);
    }
        

    
}
