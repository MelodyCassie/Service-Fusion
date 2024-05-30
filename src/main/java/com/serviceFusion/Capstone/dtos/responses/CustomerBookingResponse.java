package com.serviceFusion.Capstone.dtos.responses;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class CustomerBookingResponse {
    private String message;
    private Long bookingId;
}
