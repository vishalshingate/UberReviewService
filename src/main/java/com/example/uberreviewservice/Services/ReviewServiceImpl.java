package com.example.uberreviewservice.Services;


import com.example.uberprojectentity.models.Review;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findReviewByBookingId(Long bookingId) {
        return null;
    }

    @Override
    public Optional<Review> findReviewById(Long id) {
        return reviewRepository.findById(Math.toIntExact(id));
    }



    @Override
    public boolean deleteReviewById(Integer bookingId) {
        try {
            reviewRepository.deleteById(bookingId);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Review publishReview(Review review) {
        try {
           return reviewRepository.save(review);
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return review;
    }
}
