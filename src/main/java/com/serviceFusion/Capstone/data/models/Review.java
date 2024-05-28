package com.serviceFusion.Capstone.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long customerId;
    private Long serviceProviderId;
    private Long serviceId;
    private int rating;
    private String comment;
    private LocalDateTime reviewDate;

}
