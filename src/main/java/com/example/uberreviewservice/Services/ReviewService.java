package com.example.uberreviewservice.Services;

import com.example.uberreviewservice.models.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    public List<Review> findAllReviews();



    public Review findReviewByBookingId(Long bookingId);

    Optional<Review> findReviewById(Long id);

    public boolean deleteReviewById(Integer bookingId);


    Review publishReview(Review review);
}
