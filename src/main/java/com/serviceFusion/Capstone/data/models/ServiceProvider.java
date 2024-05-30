package com.serviceFusion.Capstone.data.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    private Location location;
    @Enumerated(EnumType.STRING)
    private ServiceCategory serviceCategory;
    private String yearsOfExperience;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isLogin;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<ServiceProvided> serviceProvided;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Booking> bookings;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Customer> customers;

}
