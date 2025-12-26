package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springapp.model.Feedback;
import com.example.springapp.repository.FeedbackRepo;

@Service
public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    private FeedbackRepo frepo;
    
    @Override
    public Feedback addF(Feedback f){
        return frepo.save(f);

    }
    @Override
    public List<Feedback> getAll(){
        return frepo.findAll();
    }
    @Override
    public Feedback getById(Long id){
        return frepo.findById(id).orElse(null);
    }
    
}

