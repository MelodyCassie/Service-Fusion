//package com.serviceFusion.Capstone.controllers;
//
//import com.serviceFusion.Capstone.dtos.requests.ServiceProviderRegistrationRequest;
//import com.serviceFusion.Capstone.dtos.responses.ServiceProviderRegistrationResponse;
//import com.serviceFusion.Capstone.exceptions.ServiceFusionException;
//import com.serviceFusion.Capstone.services.CustomerService;
//import com.serviceFusion.Capstone.services.ServiceProviderService;
//import com.serviceFusion.Capstone.services.ServiceServiceApp;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("api/v1/customer/")
//public class ServiceProviderController {
//
//    @Autowired
//    private ServiceProviderService serviceProviderService;
//
//    @PostMapping("register")
//    public ResponseEntity<ServiceProviderRegistrationResponse> register(@Valid @RequestBody ServiceProviderRegistrationRequest request) throws ServiceFusionException {
//        return new ResponseEntity<>(serviceProviderService.registerServiceProvider(request), HttpStatus.CREATED);
//
//    }
//
//}
