package com.example.uberreviewservice.Adapter;

import com.example.uberreviewservice.dtos.CreateReviewDto;
import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateReviewAdapterImpl implements CreateReviewDtoToReviewAdapter{
    private BookingRepository bookingRepository;

    public CreateReviewAdapterImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Review convertDto(CreateReviewDto createReviewDto) {
        Optional<Booking> booking = bookingRepository.findById(createReviewDto.getBooking_id());
        if(booking.isPresent()){
            Review review = Review.builder().rating(createReviewDto.getRating())
                .booking(booking.get())
                .content(createReviewDto.getContent())
                .build();

            return review;
        }
        return null;
    }
}
