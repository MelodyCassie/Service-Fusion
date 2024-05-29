package com.serviceFusion.Capstone.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class PaymentRequest {
    private Long bookingId;
    private Long customerId;
    private BigDecimal amount;
}
