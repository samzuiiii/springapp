package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Feedback;

public interface FeedbackService{
      public Feedback addF(Feedback f);
      public List<Feedback> getAll();
      public Feedback getById(Long id);
    
}

