package com.serviceFusion.Capstone.dtos.responses;

import com.serviceFusion.Capstone.data.models.Payment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ViewCustomerPaymentResponse {
    private List<Payment> customerPayment;
}
