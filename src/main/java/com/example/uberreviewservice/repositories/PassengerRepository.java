package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
