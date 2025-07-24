package com.example.uberreviewservice.Adapter;

import com.example.uberprojectentity.models.Review;
import com.example.uberreviewservice.dtos.ReviewDto;


public interface ResponseReviewAdapter {
    public ReviewDto convertReviewToJson(Review review);
}
