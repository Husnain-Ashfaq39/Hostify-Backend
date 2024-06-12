package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Review;

import java.util.List;

public interface ReviewService {
    Review saveReview(Review review);
    List<Review> findByUserId(int userId);
    List<Review> findByHostelId(int hostelId);
}
