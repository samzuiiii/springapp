package com.example.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long feedbackId;
   private String content;
   public Feedback() {
   }
   public Feedback(String content) {
    this.content = content;
   }
   public Long getFeedbackId() {
    return feedbackId;
   }
   public void setFeedbackId(Long feedbackId) {
    this.feedbackId = feedbackId;
   }
   public String getContent() {
    return content;
   }
   public void setContent(String content) {
    this.content = content;
   }
   
    
   
    

    
}