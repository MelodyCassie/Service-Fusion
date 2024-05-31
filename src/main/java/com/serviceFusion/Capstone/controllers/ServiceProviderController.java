package com.serviceFusion.Capstone.controllers;

import com.serviceFusion.Capstone.data.models.ServiceProvider;
import com.serviceFusion.Capstone.data.repositories.ServiceProvidedRepository;
import com.serviceFusion.Capstone.data.repositories.ServiceProviderRepository;
import com.serviceFusion.Capstone.dtos.requests.FindServiceProviderByCategoryRequest;
import com.serviceFusion.Capstone.dtos.requests.FindServiceProviderByLocationRequest;
import com.serviceFusion.Capstone.dtos.requests.ServiceProviderRegistrationRequest;
import com.serviceFusion.Capstone.dtos.responses.FIndServiceProviderByLocationResponse;
import com.serviceFusion.Capstone.dtos.responses.FindServiceProviderByCategoryResponse;
import com.serviceFusion.Capstone.dtos.responses.ServiceProviderRegistrationResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;

import com.serviceFusion.Capstone.services.ServiceProviderService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/serviceProvider/")
@AllArgsConstructor
public class ServiceProviderController {


    private final ServiceProviderService serviceProviderService;
    private final ServiceProviderRepository serviceProviderRepository;
    private final ServiceProvidedRepository serviceProvidedRepository;

    @PostMapping("register")
    public ResponseEntity<ServiceProviderRegistrationResponse> register(@Valid @RequestBody ServiceProviderRegistrationRequest request) throws ServiceFusionException {
        return new ResponseEntity<>(serviceProviderService.registerServiceProvider(request), HttpStatus.CREATED);

    }
    @GetMapping("searchByCategory")
    public ResponseEntity<FindServiceProviderByCategoryResponse> searchForServiceProviderByCategory(@RequestBody FindServiceProviderByCategoryRequest request) throws ServiceFusionException {
        return new ResponseEntity<>(serviceProviderService.findByServiceCategory(request), HttpStatus.OK);
    }
    @GetMapping("searchByLocation")
    public ResponseEntity<FIndServiceProviderByLocationResponse> searchForServiceProviderByLocation(@RequestBody FindServiceProviderByLocationRequest request) throws ServiceFusionException {
        return new ResponseEntity<>(serviceProviderService.findByLocation(request), HttpStatus.OK);
    }

    @GetMapping("getAllServiceProvider")
    public ResponseEntity<List<ServiceProvider>> getAllServiceProvider(){
        return new ResponseEntity<>(serviceProviderRepository.findAll(), HttpStatus.OK);
    }


}
