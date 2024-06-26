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
    private String preferredDate;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus = BookingStatus.ACCEPTED;
}
