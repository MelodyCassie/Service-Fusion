package com.serviceFusion.Capstone.data.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Entity
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String fullName;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean loginStatus;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Booking> bookings;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Review> reviews;
    @OneToMany(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Payment> payments;
}
