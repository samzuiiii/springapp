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

import com.example.springapp.model.Feedback;
import com.example.springapp.service.FeedbackService;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {
      @Autowired
      private FeedbackService fser;
      
      @PostMapping
      public ResponseEntity<Feedback> addF(@RequestBody Feedback f){
        Feedback saved=fser.addF(f);
        return new ResponseEntity<>(saved,HttpStatus.OK);
      }
      @GetMapping
      public ResponseEntity<List<Feedback>> getAll(){
        List<Feedback> list=fser.getAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
      }
      @GetMapping("/{id}")
      public ResponseEntity<Feedback> getById(@PathVariable Long id){
        Feedback fd=fser.getById(id);
        return new ResponseEntity<>(fd,HttpStatus.OK);
      }

}

