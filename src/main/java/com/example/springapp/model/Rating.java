package com.example.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ratingId;
    private int rating;
    public Rating() {
    }
    public Rating(int rating) {
        this.rating = rating;
    }
    public long getRatingId() {
        return ratingId;
    }
    public void setRatingId(long ratingId) {
        this.ratingId = ratingId;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
  
    
 
}