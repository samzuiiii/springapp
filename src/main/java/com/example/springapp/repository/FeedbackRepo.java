package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Feedback;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback,Long>{

    
}
