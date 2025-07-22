package com.example.uberreviewservice.Controller;

import com.example.uberreviewservice.Adapter.CreateReviewDtoToReviewAdapter;
import com.example.uberreviewservice.Adapter.ResponseReviewAdapter;
import com.example.uberreviewservice.Adapter.ResponseReviewAdapterImpl;
import com.example.uberreviewservice.Services.ReviewService;
import com.example.uberreviewservice.dtos.CreateReviewDto;
import com.example.uberreviewservice.dtos.ReviewDto;
import com.example.uberreviewservice.models.Review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private ReviewService reviewService;

    private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;
    private ResponseReviewAdapter reviewAdapter;

    public ReviewController(CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter, ReviewService reviewService,
                            ResponseReviewAdapter reviewAdapter) {
        this.reviewService = reviewService;
        this.createReviewDtoToReviewAdapter = createReviewDtoToReviewAdapter;
        this.reviewAdapter = reviewAdapter;
    }
    @PostMapping
    public ResponseEntity<?> publishReview(@RequestBody CreateReviewDto request) {
        Review incomingReview = createReviewDtoToReviewAdapter.convertDto(request);
        if(incomingReview== null) {
            return new ResponseEntity<>("Invalid arguments", HttpStatus.BAD_REQUEST);
        }

        Review review = this.reviewService.publishReview(incomingReview);
        ReviewDto reviewDto = reviewAdapter.convertReviewToJson(review);

        return new ResponseEntity<>(reviewDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findReviewById(@PathVariable Long id) {
        Optional<Review> review =  reviewService.findReviewById(id);
        if(review.isEmpty()) {
            return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
        }
        ReviewDto reviewDto = reviewAdapter.convertReviewToJson(review.get());
        return new ResponseEntity<>(reviewDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAllReviews() {
        List<Review> reviews = reviewService.findAllReviews();
        List<ReviewDto> reviewsDts = new ArrayList<>();
        for(Review review : reviews) {
            ReviewDto reviewDto = reviewAdapter.convertReviewToJson(review);
            reviewsDts.add(reviewDto);
        }
        return new ResponseEntity<>(reviewsDts, HttpStatus.OK);
    }

}
