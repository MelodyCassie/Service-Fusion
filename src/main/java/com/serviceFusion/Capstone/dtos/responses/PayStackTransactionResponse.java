package com.serviceFusion.Capstone.dtos.responses;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class PayStackTransactionResponse {

    private boolean status;
    private String message;
    @JsonProperty("data")
    private PaystackTransactionDetails transactionDetails;
}
