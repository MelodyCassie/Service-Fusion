package com.serviceFusion.Capstone.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminDeleteCustomerRequest {
    private Long adminId;
    private Long customerId;
}
