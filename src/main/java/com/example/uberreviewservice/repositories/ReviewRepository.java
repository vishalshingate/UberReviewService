package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
