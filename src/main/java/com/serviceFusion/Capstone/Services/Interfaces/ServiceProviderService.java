package com.serviceFusion.Capstone.Services.Interfaces;

import com.serviceFusion.Capstone.data.models.ServiceProvider;
import com.serviceFusion.Capstone.dtos.request.ServiceProviderRequest;

public interface ServiceProviderService {
    ServiceProvider registerServiceProvider(ServiceProviderRequest request);

}
