package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.data.models.Customer;
import com.serviceFusion.Capstone.dtos.requests.*;
import com.serviceFusion.Capstone.dtos.responses.*;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;

public interface CustomerService {
    CustomerRegistrationResponse register(CustomerRegistrationRequest customerRegistrationRequest) throws ServiceFusionException;

    LoginResponse login(CustomerLoginRequest request) throws ServiceFusionException;

    CustomerUpdateResponse updateCustomer(CustomerUpdateProfileRequest request) throws ServiceFusionException;

    SearchServiceProviderResponse searchForServiceProvider(SearchServiceProviderRequest request);

    CustomerBookingResponse bookService(CustomerBookingRequest request) throws ServiceFusionException;

    Customer findById(Long customerId);

    void save(Customer existingCustomer);
}
