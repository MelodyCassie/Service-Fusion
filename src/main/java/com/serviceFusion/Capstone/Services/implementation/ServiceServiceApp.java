package com.serviceFusion.Capstone.services.implementation;

import com.serviceFusion.Capstone.services.interfaces.ServiceService;
import com.serviceFusion.Capstone.data.models.ServiceProvided;
import com.serviceFusion.Capstone.dtos.requests.ServiceCreationRequest;
import com.serviceFusion.Capstone.dtos.responses.ServiceCreationResponse;
import com.serviceFusion.Capstone.data.repositories.ServiceProvidedRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceServiceApp implements ServiceService {
    private final ModelMapper modelMapper;
    private final ServiceProvidedRepository serviceProvidedRepository;

    @Override
    public ServiceCreationResponse createService(ServiceCreationRequest request) {
        ServiceProvided serviceProvided = modelMapper.map(request, ServiceProvided.class);
        serviceProvided.setServiceCategory(request.getServiceCategory());
        serviceProvidedRepository.save(serviceProvided);

        ServiceCreationResponse response = new ServiceCreationResponse();
        response.setServiceId(response.getServiceId());
        response.setServiceName(response.getServiceName());
        response.setMessage("Service created successfully");
        return response;
    }
}
