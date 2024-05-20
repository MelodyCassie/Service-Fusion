package com.serviceFusion.Capstone.data.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Entity
@Getter
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String description;
    private ServiceCategory serviceCategory;
    private String experience;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Admin admin;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Service> services;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Booking> bookings;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Customer> customers;

}
