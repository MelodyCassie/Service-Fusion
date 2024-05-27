package com.serviceFusion.Capstone.controllers;



import com.serviceFusion.Capstone.data.models.ServiceProvider;
import com.serviceFusion.Capstone.dtos.requests.ServiceProviderRegistrationRequest;
import com.serviceFusion.Capstone.exceptions.EmailAlreadyExistsException;
import com.serviceFusion.Capstone.exceptions.InvalidEmailFormatException;
import com.serviceFusion.Capstone.services.ServiceProviderService;
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

    public ResponseEntity<ServiceProvider> registerServiceProvider(@RequestBody ServiceProviderRegistrationRequest serviceProviderRegistrationRequest) throws EmailAlreadyExistsException, InvalidEmailFormatException {
        return new ResponseEntity<>(serviceProviderService.registerServiceProvider(serviceProviderRegistrationRequest), HttpStatus.CREATED);
    }

}
