package com.serviceFusion.Capstone.controllers;

import com.serviceFusion.Capstone.data.models.Customer;
import com.serviceFusion.Capstone.data.repositories.CustomerRepository;
import com.serviceFusion.Capstone.dtos.requests.*;
import com.serviceFusion.Capstone.dtos.responses.*;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;

import com.serviceFusion.Capstone.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    @PostMapping("register")
    public ResponseEntity<CustomerRegistrationResponse> register(@RequestBody CustomerRegistrationRequest registrationRequest) throws ServiceFusionException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.register(registrationRequest));
    }
    @PostMapping("bookService")
    public ResponseEntity<CustomerBookingResponse> bookForService(@RequestBody CustomerBookingRequest bookingRequest) throws ServiceFusionException {
        return new ResponseEntity<>(customerService.bookService(bookingRequest), HttpStatus.CREATED);
    }


    @GetMapping("getAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("getCustomerBooking")
    public ResponseEntity<ViewAllCustomerBookingResponse> viewCustomerBooking(@RequestBody ViewAllCustomerBookingRequest request) throws ServiceFusionException {
        return new ResponseEntity<>(customerService.viewCustomerBooking(request), HttpStatus.OK);
    }
    @GetMapping("viewCustomerPaymentHistory")
    public ResponseEntity <ViewCustomerPaymentResponse> viewCustomerPaymentHistory(@RequestBody ViewCustomerPaymentRequest request) throws ServiceFusionException {
        return new ResponseEntity<>(customerService.viewCustomerPaymentHistory(request),HttpStatus.OK);
    }

    @PostMapping("searchForServiceProvider")
    public ResponseEntity<SearchServiceProviderResponse> searchForServiceProvider(@RequestBody SearchServiceProviderRequest request){
        return new ResponseEntity<>(customerService.searchForServiceProvider(request),HttpStatus.OK);
    }
}