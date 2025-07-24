package com.example.uberreviewservice.repositories;


import com.example.uberprojectentity.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
