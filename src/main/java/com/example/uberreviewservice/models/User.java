package com.example.uberreviewservice.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User extends BaseModel {

    @Column(nullable = false)
    private String firstName;


}
