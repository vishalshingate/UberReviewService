package com.example.uberreviewservice;

import com.example.uberprojectentity.models.Review;
import com.example.uberreviewservice.Adapter.CreateReviewDtoToReviewAdapter;
import com.example.uberreviewservice.Adapter.ResponseReviewAdapter;
import com.example.uberreviewservice.Controller.ReviewController;
import com.example.uberreviewservice.Services.ReviewService;

import com.example.uberreviewservice.dtos.ReviewDto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewControllerTest {

    @InjectMocks
    private ReviewController reviewController;

    @Mock
    private ReviewService reviewService;

    @Mock
    private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;

    @Mock
    private ResponseReviewAdapter reviewAdapter;
    /**
     *
     * Mockito will go through the class and will make mock instances of the all field which are annotated with @mock
     * and take that instances and inject those into the field which you have annotated with @injectMock
     *
     *
     */
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindReviewById(){
        long reviewId = 1L;
        Review mockReview = Review.builder().build();
        mockReview.setId(reviewId);

        ReviewDto mockDto = new ReviewDto(); // mock or real, as per your code
        Mockito.when(reviewService.findReviewById(reviewId)).thenReturn(Optional.of(mockReview));
        Mockito.when(reviewAdapter.convertReviewToJson(mockReview)).thenReturn(mockDto);

        //perform test
        ResponseEntity<?> response= reviewController.findReviewById(reviewId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockDto, response.getBody());
    }




}
