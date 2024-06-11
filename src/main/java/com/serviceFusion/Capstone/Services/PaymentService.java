package com.serviceFusion.Capstone.services;


import com.serviceFusion.Capstone.dtos.requests.PaymentRequest;
import com.serviceFusion.Capstone.dtos.responses.PaymentResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;

public interface PaymentService {
    PaymentResponse payForBooking(PaymentRequest request) throws ServiceFusionException;

}
