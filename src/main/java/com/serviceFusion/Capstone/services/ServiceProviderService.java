package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.data.models.ServiceCategory;
import com.serviceFusion.Capstone.data.models.ServiceProvider;
import com.serviceFusion.Capstone.dtos.requests.*;
import com.serviceFusion.Capstone.dtos.responses.FIndServiceProviderByLocationResponse;
import com.serviceFusion.Capstone.dtos.responses.FindServiceProviderByCategoryResponse;
import com.serviceFusion.Capstone.dtos.responses.ServiceProviderLoginResponse;
import com.serviceFusion.Capstone.dtos.responses.ServiceProviderRegistrationResponse;
import com.serviceFusion.Capstone.exceptions.IncorrectPasswordException;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;
import com.serviceFusion.Capstone.exceptions.UserNotFoundException;

import java.util.List;

public interface ServiceProviderService {
    ServiceProviderRegistrationResponse registerServiceProvider(ServiceProviderRegistrationRequest request) throws ServiceFusionException;

    FIndServiceProviderByLocationResponse findByLocation(FindServiceProviderByLocationRequest request) throws ServiceFusionException;

    FindServiceProviderByCategoryResponse findByServiceCategory(FindServiceProviderByCategoryRequest request) throws ServiceFusionException;

    List<ServiceProvider> findByServiceProvideByCategory(ServiceCategory category);

    ServiceProviderLoginResponse login(ServiceProviderLoginRequest request) throws UserNotFoundException, IncorrectPasswordException;

    void logout(ServiceProviderLogoutRequest request);
}
