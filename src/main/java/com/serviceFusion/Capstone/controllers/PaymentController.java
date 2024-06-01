package com.serviceFusion.Capstone.controllers;

import com.serviceFusion.Capstone.dtos.requests.PaymentRequest;
import com.serviceFusion.Capstone.dtos.responses.PaymentResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;
import com.serviceFusion.Capstone.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/payment/")
@AllArgsConstructor
public class PaymentController {


    private PaymentService paymentService;

    @PostMapping("makePayment")
    public ResponseEntity<PaymentResponse> makePayment(@RequestBody PaymentRequest request) throws ServiceFusionException {
        return new ResponseEntity<>(paymentService.payForBooking(request), HttpStatus.CREATED);
    }
}
