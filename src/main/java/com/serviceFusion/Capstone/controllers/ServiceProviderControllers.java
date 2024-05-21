package com.serviceFusion.Capstone.controllers;


import com.serviceFusion.Capstone.Services.Interfaces.ServiceProviderService;
import com.serviceFusion.Capstone.data.models.ServiceProvider;
import com.serviceFusion.Capstone.dtos.request.ServiceProviderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/ServiceFusion/")
public class ServiceProviderControllers {

    private final ServiceProviderService serviceProviderService;
    @PostMapping("registerServiceProvider")

    public ResponseEntity<ServiceProvider> registerServiceProvider(@RequestBody ServiceProviderRequest serviceProviderRequest){
        return new ResponseEntity<>(serviceProviderService.registerServiceProvider(serviceProviderRequest), HttpStatus.CREATED);
    }

}
