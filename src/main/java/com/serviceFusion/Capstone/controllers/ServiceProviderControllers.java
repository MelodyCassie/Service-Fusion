package com.serviceFusion.Capstone.controllers;


import com.serviceFusion.Capstone.Services.Interfaces.ServiceProviderService;
import com.serviceFusion.Capstone.dtos.requests.ServiceProviderRequest;
import com.serviceFusion.Capstone.dtos.responses.ServiceProviderResponse;
import com.serviceFusion.Capstone.exceptions.EmailAlreadyExistsException;
import com.serviceFusion.Capstone.exceptions.InvalidEmailFormatException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/ServiceFusion/")
//@CrossOrigin(origins = "http://localhost:3000")
public class ServiceProviderControllers {



    private final ServiceProviderService serviceProviderService;
    @PostMapping("registerServiceProvider")

    public ResponseEntity<ServiceProviderResponse> registerServiceProvider(@RequestBody ServiceProviderRequest serviceProviderRequest) throws EmailAlreadyExistsException, InvalidEmailFormatException {
        return new ResponseEntity<>(serviceProviderService.registerServiceProvider(serviceProviderRequest), HttpStatus.CREATED);
    }

}
