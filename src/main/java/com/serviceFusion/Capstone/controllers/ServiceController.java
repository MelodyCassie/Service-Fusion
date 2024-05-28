package com.serviceFusion.Capstone.controllers;

import com.serviceFusion.Capstone.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer/")
@AllArgsConstructor
public class ServiceController {

    private final CustomerService customerService;
}
