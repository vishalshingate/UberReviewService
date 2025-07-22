package com.example.uberreviewservice.Controller;

import com.example.uberreviewservice.Services.ReviewService;
import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Driver;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.DriverRepository;
import com.example.uberreviewservice.repositories.PassengerRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    private DriverRepository driverRepository;

    @GetMapping("/drivers/bookings")
    @Transactional
    public List<Booking> getBookingsByDriverIds(@RequestParam List<Long> driverIds) {
        List<Driver> drivers = driverRepository.findAllByIdIn(driverIds);
        //drivers.forEach(driver-> System.out.println(driver.getBookings()));
        for (Driver driver : drivers) {
            driver.getBookings().forEach(booking -> System.out.print(booking));
        }
        return new ArrayList<>();
    }

}
