package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
  Optional<Driver> findByIdAndLicenceNumber(Long id, String licenceNumber);
  @Query(nativeQuery = true, value = "SELECT * FROM driver WHERE id IN (:driverIds)")
  List<Driver> findDriverByBookingIds(@Param("driverIds") List<Long> driverIds);

  List<Driver> findAllByIdIn(Collection<Long> ids);
}
