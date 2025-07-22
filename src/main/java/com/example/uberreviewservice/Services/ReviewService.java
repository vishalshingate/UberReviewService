package com.example.uberreviewservice.Services;

import com.example.uberreviewservice.models.Review;

import java.util.List;

public interface ReviewService {
    public List<Review> findAllReviews();

    public Review findReviewById(Long bookingId);

    public boolean deleteReviewById(Integer bookingId);


}
