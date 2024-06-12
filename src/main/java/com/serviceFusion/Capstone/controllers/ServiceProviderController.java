package com.serviceFusion.Capstone.controllers;

import com.serviceFusion.Capstone.data.models.ServiceProvider;
import com.serviceFusion.Capstone.data.repositories.ServiceProviderRepository;
import com.serviceFusion.Capstone.dtos.requests.*;
import com.serviceFusion.Capstone.dtos.responses.*;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;

import com.serviceFusion.Capstone.services.ServiceProviderService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/serviceProvider/")
@AllArgsConstructor
public class ServiceProviderController {


    private final ServiceProviderService serviceProviderService;
    private final ServiceProviderRepository serviceProviderRepository;

    @PostMapping("register")
    public ResponseEntity<ServiceProviderRegistrationResponse> register( @RequestBody ServiceProviderRegistrationRequest request) throws ServiceFusionException {
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

    @PostMapping("uploadProfilePicture")
    public ResponseEntity<UploadImageResponse> uploadProfilePicture( @RequestBody ServiceProviderUploadImageRequest request) throws ServiceFusionException, IOException {
        return new ResponseEntity<>(serviceProviderService.uploadProfilePicture(request),HttpStatus.CREATED);
    }


}
