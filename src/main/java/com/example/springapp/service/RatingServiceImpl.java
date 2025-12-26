package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.springapp.model.Rating;
import com.example.springapp.repository.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepo rrepo;

    @Override
    public Rating addR(Rating r){
        return rrepo.save(r);
    }
    @Override
    public List<Rating> getAll(){
        return rrepo.findAll();
    }
    @Override
    public Rating getById(Long id){
        return rrepo.findById(id).orElse(null);
    }
    
    
}

