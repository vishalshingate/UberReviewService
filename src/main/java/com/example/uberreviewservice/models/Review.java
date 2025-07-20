package com.example.uberreviewservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Review {
    @Id// this annotation makes the is property a primary key of our table
    Long id;
}
