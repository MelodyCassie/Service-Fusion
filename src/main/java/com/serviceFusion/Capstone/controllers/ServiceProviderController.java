package com.serviceFusion.Capstone.controllers;

import com.serviceFusion.Capstone.dtos.requests.AdminLoginRequest;
import com.serviceFusion.Capstone.dtos.requests.ServiceProviderLoginRequest;
import com.serviceFusion.Capstone.dtos.requests.ServiceProviderRegistrationRequest;
import com.serviceFusion.Capstone.dtos.responses.AdminLoginResponse;
import com.serviceFusion.Capstone.dtos.responses.ServiceProviderLoginResponse;
import com.serviceFusion.Capstone.dtos.responses.ServiceProviderRegistrationResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;

import com.serviceFusion.Capstone.services.ServiceProviderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/ServiceFusion/")
public class ServiceProviderController {

    @Autowired
    private final ServiceProviderService serviceProviderService;



    @PostMapping("registerServiceProvider")
    public ResponseEntity<ServiceProviderRegistrationResponse> register(@RequestBody ServiceProviderRegistrationRequest request) throws ServiceFusionException {
        return new ResponseEntity<>(serviceProviderService.registerServiceProvider(request), HttpStatus.CREATED);

    }
    @PostMapping("loginServiceProvider")
    public ResponseEntity<ServiceProviderLoginResponse> loginProvider( @RequestBody ServiceProviderLoginRequest request) throws ServiceFusionException {
        return new ResponseEntity<>(serviceProviderService.login(request),HttpStatus.OK);
    }

}
