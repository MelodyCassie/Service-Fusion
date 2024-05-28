package com.serviceFusion.Capstone.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServiceCreationResponse {
    private Long serviceId;
    private String serviceName;
    private String message;
}
