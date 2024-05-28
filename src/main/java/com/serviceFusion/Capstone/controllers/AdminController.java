package com.serviceFusion.Capstone.controllers;


import com.serviceFusion.Capstone.Services.AdminService;
import com.serviceFusion.Capstone.dtos.requests.AdminRegistrationRequest;
import com.serviceFusion.Capstone.dtos.responses.AdminRegistrationResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin/")
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;
//    private final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @PostMapping("register")
    public ResponseEntity<AdminRegistrationResponse> addAdmin(@RequestBody AdminRegistrationRequest request) throws ServiceFusionException {
//        logger.trace("Entering addAdmin method");
        return ResponseEntity.status((HttpStatus.CREATED))
                .body(adminService.registerAdmin(request));
    }
}
