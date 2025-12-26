package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.example.springapp.model.Category;
import com.example.springapp.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService cser;
    
    @PostMapping
    public ResponseEntity<Category> addC(@Valid @RequestBody Category c){
        Category saved=cser.addC(c);
        if(saved==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(saved,HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Category>> getAllc(){
        List<Category> list=cser.getAllc();
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCbyId(@PathVariable Long id){
        Category idp=cser.getCbyId(id);
        return new ResponseEntity<>(idp,HttpStatus.OK);
        
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> putCbyId(@PathVariable Long id,@RequestBody Category c){
        Category udp=cser.putCbyId(id,c);
        return new ResponseEntity<>(udp,HttpStatus.OK);
        
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletvoidebyId(@PathVariable Long id){
        cser.deletebyId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
        
    }
    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<Category>> getByPage(@PathVariable int page,@PathVariable int size){
        Page<Category> list=cser.getByPage(page,size);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    
}
