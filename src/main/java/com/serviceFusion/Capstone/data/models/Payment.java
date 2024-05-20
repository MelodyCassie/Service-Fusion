package com.serviceFusion.Capstone.data.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long customerId;
    private Long bookingId;
    private LocalDateTime paymentDate;
    private BigDecimal amount;
//    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    private User user;
//    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    private Booking booking;

}
