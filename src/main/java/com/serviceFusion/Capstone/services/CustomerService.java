package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.dtos.requests.CustomerRegistrationRequest;
import com.serviceFusion.Capstone.dtos.requests.CustomerLoginRequest;
import com.serviceFusion.Capstone.dtos.requests.CustomerUpdateProfileRequest;
import com.serviceFusion.Capstone.dtos.requests.SearchServiceProviderRequest;
import com.serviceFusion.Capstone.dtos.responses.CustomerRegistrationResponse;
import com.serviceFusion.Capstone.dtos.responses.CustomerUpdateResponse;
import com.serviceFusion.Capstone.dtos.responses.LoginResponse;
import com.serviceFusion.Capstone.dtos.responses.SearchServiceProviderResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;

public interface CustomerService {
    CustomerRegistrationResponse register(CustomerRegistrationRequest customerRegistrationRequest) throws ServiceFusionException;

    LoginResponse login(CustomerLoginRequest request) throws ServiceFusionException;

    CustomerUpdateResponse updateCustomer(CustomerUpdateProfileRequest request) throws ServiceFusionException;

    SearchServiceProviderResponse searchForServiceProvider(SearchServiceProviderRequest request);
}
