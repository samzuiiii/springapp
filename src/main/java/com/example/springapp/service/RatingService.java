package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Rating;

public interface RatingService {
    public Rating addR(Rating r);
    public List<Rating> getAll();
    public Rating getById(Long id);
    

    
}

