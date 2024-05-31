package com.serviceFusion.Capstone.controllers;

import com.serviceFusion.Capstone.dtos.requests.CustomerBookingRequest;
import com.serviceFusion.Capstone.dtos.requests.CustomerRegistrationRequest;
import com.serviceFusion.Capstone.dtos.requests.FindServiceProviderByLocationRequest;
import com.serviceFusion.Capstone.dtos.responses.CustomerBookingResponse;
import com.serviceFusion.Capstone.dtos.responses.CustomerRegistrationResponse;
import com.serviceFusion.Capstone.dtos.responses.FIndServiceProviderByLocationResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;

import com.serviceFusion.Capstone.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer/")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping("register")
    public ResponseEntity<CustomerRegistrationResponse> register(@RequestBody CustomerRegistrationRequest registrationRequest) throws ServiceFusionException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.register(registrationRequest));
    }
    @PostMapping("bookService")
    public ResponseEntity<CustomerBookingResponse> bookForService(@RequestBody CustomerBookingRequest bookingRequest) throws ServiceFusionException {
        return new ResponseEntity<>(customerService.bookService(bookingRequest), HttpStatus.CREATED);
    }

}
