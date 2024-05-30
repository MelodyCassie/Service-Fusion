package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.dtos.requests.ServiceCreationRequest;
import com.serviceFusion.Capstone.dtos.responses.ServiceCreationResponse;

public interface ServiceProvidedService {
    ServiceCreationResponse createService(ServiceCreationRequest request);
}
