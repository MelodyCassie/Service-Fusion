package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.data.models.ServiceCategory;
import com.serviceFusion.Capstone.data.models.ServiceProvider;
import com.serviceFusion.Capstone.dtos.requests.*;
import com.serviceFusion.Capstone.dtos.responses.*;
import com.serviceFusion.Capstone.exceptions.*;

import java.util.List;

public interface ServiceProviderService {

    ServiceProviderRegistrationResponse registerServiceProvider(ServiceProviderRegistrationRequest request) throws ServiceFusionException;

    FIndServiceProviderByLocationResponse findByLocation(FindServiceProviderByLocationRequest request) throws ServiceFusionException;

    FindServiceProviderByCategoryResponse findByServiceCategory(FindServiceProviderByCategoryRequest request) throws ServiceFusionException;

    List<ServiceProvider> findByServiceProvideByCategory(ServiceCategory category);

    ServiceProviderLoginResponse login(ServiceProviderLoginRequest request) throws UserNotFoundException, IncorrectPasswordException;

    void logout(ServiceProviderLogoutRequest request);
}
