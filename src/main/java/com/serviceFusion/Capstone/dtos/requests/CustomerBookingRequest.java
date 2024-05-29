package com.serviceFusion.Capstone.dtos.requests;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerBookingRequest {
    private Long customerId;
    private String customerName;
    private String customerAddress;
    private String preferredDate;

}
