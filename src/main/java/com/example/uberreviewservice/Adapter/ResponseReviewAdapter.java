package com.example.uberreviewservice.Adapter;

import com.example.uberreviewservice.dtos.ReviewDto;
import com.example.uberreviewservice.models.Review;

public interface ResponseReviewAdapter {
    public ReviewDto convertReviewToJson(Review review);
}
