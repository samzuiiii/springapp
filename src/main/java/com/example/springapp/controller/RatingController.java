package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springapp.model.Rating;
import com.example.springapp.service.RatingService;

@RestController
@RequestMapping("api/ratings")
public class RatingController {
    @Autowired
    private RatingService rser;

     @PostMapping
     public ResponseEntity<Rating> addR(@RequestBody Rating r){
            Rating saved=rser.addR(r);
            return new ResponseEntity<>(saved,HttpStatus.CREATED);
     }
      @GetMapping
      public ResponseEntity<List<Rating>> getAll(){
        List<Rating> list=rser.getAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
      }
      @GetMapping("/{id}")
      public ResponseEntity<Rating> getById(@PathVariable Long id){
        Rating fd=rser.getById(id);
        return new ResponseEntity<>(fd,HttpStatus.OK);
      }



    
}
