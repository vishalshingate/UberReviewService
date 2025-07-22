package com.example.uberreviewservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {
    private Long id;

    private String content;

    private Double rating;

    private Long bookingId;

    private Date createdAt;

    private Date updatedAt;

}
