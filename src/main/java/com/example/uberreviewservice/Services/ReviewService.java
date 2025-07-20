package com.example.uberreviewservice.Services;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner{

    private ReviewRepository reviewRepository;

    private BookingRepository bookingRepository;


    public ReviewService(ReviewRepository reviewRepository,  BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //create booking
        Review r = Review.builder().
            content("Amazing ride quality").rating(5.0).build();

        Booking booking = Booking.builder().endTime(new Date())
            .review(r).build();

        System.out.println("Review Service is running");

        System.out.println(r);
        bookingRepository.save(booking);
        reviewRepository.save(r);


        // this code execute sql query



        List<Review> reviews = reviewRepository.findAll();
        for(Review re : reviews){
            System.out.println(re);
        }


    }
}
