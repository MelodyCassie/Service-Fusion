package com.serviceFusion.Capstone.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Entity
@Getter
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private String description;
    @Enumerated(EnumType.STRING)
    private ServiceCategory serviceCategory;
    private int yearsOfExperience;
    LocalDateTime createdAt;
    LocalDateTime updated;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Admin admin;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Service> services;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Booking> bookings;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Customer> customers;

}
