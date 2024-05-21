package com.serviceFusion.Capstone.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Entity
@Getter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long customerId;
    private Long serviceProviderId;
    private Long serviceId;
    private LocalDateTime bookingDate;
    private BookingStatus bookingStatus;
//    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    private User user;
//    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    private ServiceProvider serviceProvider;
//    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    private Service service;

}