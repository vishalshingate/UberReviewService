package com.example.uberreviewservice.Services;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Driver;
import com.example.uberreviewservice.models.Passenger;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.DriverRepository;
import com.example.uberreviewservice.repositories.PassengerRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner{

    private ReviewRepository reviewRepository;

    private BookingRepository bookingRepository;
    private DriverRepository driverRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    public ReviewService(ReviewRepository reviewRepository,  BookingRepository bookingRepository, DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       // create booking
//        Review r = Review.builder().
//            content("Amazing ride quality").rating(5.0).build();
//
//        Booking booking = Booking.builder().endTime(new Date())
//            .review(r).build();
//
//        System.out.println("Review Service is running");
//
//        System.out.println(r);
//        bookingRepository.save(booking);
//        reviewRepository.save(r);
//
//
//        // this code execute sql query
//
//
//
//        List<Review> reviews = reviewRepository.findAll();
//        for(Review re : reviews){
//            System.out.println(re);
//        }


        Optional<Driver> driver = driverRepository.findByIdAndLicenceNumber(1L, "ABC123");
        if(driver.isPresent()){
            System.out.println(driver.get().getName());
        }

        List<Passenger>passengers= passengerRepository.findAll();
        for(Passenger p:passengers){
            System.out.print(p.getFirstName());
        }



    }
}
