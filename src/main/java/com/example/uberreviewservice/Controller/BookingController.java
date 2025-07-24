package com.example.uberreviewservice.Controller;


import com.example.uberprojectentity.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.DriverRepository;
import com.example.uberreviewservice.repositories.PassengerRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ReviewRepository reviewRepository;

   @GetMapping("/reviews/{id}")
    public ResponseEntity<?> findReviewByBookingId(@PathVariable Long id) {
       Optional<Review> review = reviewRepository.getReviewsById(id);
       if(review.isPresent()) {
           return ResponseEntity.ok().body(review);
       }
       else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id+" Booking with id not found");
   }


}
