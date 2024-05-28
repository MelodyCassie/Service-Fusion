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
    @NotBlank
    private String fullName;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String description;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private Location location;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private ServiceCategory serviceCategory;
    @NotBlank
    private int yearsOfExperience;
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
