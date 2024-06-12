package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Review;
import com.arjuncodes.studentsystem.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findByUserId(int userId) {
        return reviewRepository.findByUserId(userId);
    }

    @Override
    public List<Review> findByHostelId(int hostelId) {
        return reviewRepository.findByHostelId(hostelId);
    }
}
