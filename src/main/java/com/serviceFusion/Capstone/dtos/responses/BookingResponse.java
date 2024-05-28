package com.serviceFusion.Capstone.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookingResponse {
    private Long bookingId;
    private String bookingDate;
    private String message;
}
