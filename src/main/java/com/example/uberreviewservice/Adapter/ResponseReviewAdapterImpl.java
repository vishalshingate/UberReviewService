package com.example.uberreviewservice.Adapter;

import com.example.uberreviewservice.dtos.ReviewDto;
import com.example.uberreviewservice.models.Review;
import org.springframework.stereotype.Component;

@Component
public class ResponseReviewAdapterImpl implements  ResponseReviewAdapter {

    @Override
    public ReviewDto convertReviewToJson(Review review) {
        ReviewDto reviewDto = ReviewDto.builder()
            .id(review.getId())
            .rating(review.getRating())
            .content(review.getContent())
            .createdAt(review.getCreatedAt())
            .updatedAt(review.getUpdatedAt())
            .bookingId(review.getBooking().getId())
            .build();

        return reviewDto;
    }
}
