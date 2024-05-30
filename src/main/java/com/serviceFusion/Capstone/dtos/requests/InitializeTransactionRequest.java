package com.serviceFusion.Capstone.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InitializeTransactionRequest {

    private String email;
    private String amount;
}
