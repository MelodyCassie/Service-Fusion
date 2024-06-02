package com.serviceFusion.Capstone.dtos.requests;

import com.serviceFusion.Capstone.data.models.BookingStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class BookingRequest {
    private Long customerId;
    private Long serviceProviderId;
    private Long serviceId;
    private LocalDateTime bookingDate;
    private BookingStatus bookingStatus;
}
