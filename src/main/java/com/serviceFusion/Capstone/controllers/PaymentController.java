package com.serviceFusion.Capstone.controllers;

import com.serviceFusion.Capstone.data.models.Payment;
import com.serviceFusion.Capstone.data.repositories.PaymentRepository;
import com.serviceFusion.Capstone.dtos.requests.PaymentRequest;
import com.serviceFusion.Capstone.dtos.responses.PaymentResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;
import com.serviceFusion.Capstone.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/payment/")
@AllArgsConstructor
public class PaymentController {


    private final PaymentRepository paymentRepository;
    private PaymentService paymentService;

    @PostMapping("makePayment")
    public ResponseEntity<PaymentResponse> makePayment(@RequestBody PaymentRequest request) throws ServiceFusionException {
        return new ResponseEntity<>(paymentService.payForBooking(request), HttpStatus.CREATED);
    }

    @GetMapping("getAllPaymentHistory")
    public ResponseEntity <List<Payment>> getAllPaymentHistory(){
        return new ResponseEntity<>(paymentRepository.findAll(), HttpStatus.OK);
    }


}
