package com.example.uberreviewservice.Adapter;

import com.example.uberprojectentity.models.Review;
import com.example.uberreviewservice.dtos.CreateReviewDto;

public interface CreateReviewDtoToReviewAdapter {

    public Review convertDto(CreateReviewDto createReviewDto);
}
