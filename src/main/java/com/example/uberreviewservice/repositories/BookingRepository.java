package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findAllByDriverId(Long driverId);
    // Find bookings by multiple driver IDs
   // @Query(nativeQuery = true, value = "SELECT * FROM booking WHERE driver_id IN (:driverIds)")
   // List<Booking> findBookingsByDriverIds(@Param("driverIds") List<Driver> driverIds);

    List<Booking> findAllByDriverIn(List<Driver> drivers);
}
