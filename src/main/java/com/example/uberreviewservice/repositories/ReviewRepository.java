package com.example.uberreviewservice.repositories;


import com.example.uberprojectentity.models.Driver;
import com.example.uberprojectentity.models.Passenger;
import com.example.uberprojectentity.models.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    Integer countAllByRatingIsLessThanEqual(Double rating);
    List<Review> findAllByRatingIsLessThan(Double ratingIsLessThan);

    Integer countAllByRatingIsGreaterThanEqual(Double rating);
    List<Review> findAllByRatingIsGreaterThanEqual(Double ratingIsGreaterThan);

    List<Review> findAllByCreatedAtBefore(Date createdAtBefore);

    @Query("select r from Booking b  inner join Review r  where b.id = :bookingId")
    Review findReviewByBookingId(Long bookingId); // this we need because we made @oneToOne mapping Lazy

    Optional<Review> getReviewsById(Long id);

//    @Query("select com.example.uberreviewservice.repositories(r,p,d) from Booking b inner join Passenger  p inner join Driver d where id =:bookingId")
//    custom findDriverPassengerReviewByBookingId(Long bookingId);

}

class custom {
    public Review review;
    public Passenger passenger;
    public Driver driver;

    public custom(Review review, Passenger passenger, Driver driver) {
        this.review = review;
        this.passenger = passenger;
        this.driver = driver;
    }
}
