package com.serviceFusion.Capstone.services.interfaces;

import com.serviceFusion.Capstone.dtos.requests.ServiceCreationRequest;
import com.serviceFusion.Capstone.dtos.responses.ServiceCreationResponse;

public interface ServiceService {
    ServiceCreationResponse createService(ServiceCreationRequest request);
}
