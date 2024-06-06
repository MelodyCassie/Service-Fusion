package com.serviceFusion.Capstone.controllers;

import com.serviceFusion.Capstone.data.models.Customer;
import com.serviceFusion.Capstone.dtos.requests.*;
import com.serviceFusion.Capstone.dtos.responses.AdminLoginResponse;
import com.serviceFusion.Capstone.dtos.responses.AdminRegistrationResponse;
import com.serviceFusion.Capstone.dtos.responses.AdminUpdateProfileResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;

import com.serviceFusion.Capstone.services.AdminService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/")
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("register")
    public ResponseEntity<AdminRegistrationResponse> addAdmin(@Valid @RequestBody AdminRegistrationRequest request) throws ServiceFusionException {
        return new ResponseEntity<>(adminService.registerAdmin(request), HttpStatus.CREATED);
    }

    @PostMapping("update")
    public ResponseEntity<AdminUpdateProfileResponse> updateAdmin(@Valid @RequestBody AdminUpdateProfileRequest request) throws ServiceFusionException {
        return new ResponseEntity<>(adminService.updateProfile(request),HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<AdminLoginResponse> loginAdmin(@Valid @RequestBody AdminLoginRequest request) throws ServiceFusionException {
        return new ResponseEntity<>(adminService.login(request),HttpStatus.OK);
    }

   @GetMapping("findAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers(AdminViewAllCustomersRequest request) throws ServiceFusionException {
        return new ResponseEntity<>(adminService.findAllCustomers(request),HttpStatus.OK);

   }

}
