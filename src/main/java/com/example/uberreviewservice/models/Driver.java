package com.example.uberreviewservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Driver extends BaseModel {




    private String name;

    @Column(nullable = false, unique = true)
    private String licenceNumber;


    @OneToMany(mappedBy ="driver")
    private List<Booking> bookings = new ArrayList<>();

}
