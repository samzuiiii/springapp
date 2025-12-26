package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating,Long>{

    
}