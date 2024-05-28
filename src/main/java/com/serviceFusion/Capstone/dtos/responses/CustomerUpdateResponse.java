package com.serviceFusion.Capstone.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerUpdateResponse {
    private Long customerId;
    private String message;
}
