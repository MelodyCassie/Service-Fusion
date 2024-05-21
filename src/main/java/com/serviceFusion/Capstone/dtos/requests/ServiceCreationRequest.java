package com.serviceFusion.Capstone.dtos.requests;

import com.serviceFusion.Capstone.data.models.ServiceCategory;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ServiceCreationRequest {
    private Long serviceProviderId;
    private String name;
    private String Description;
    private BigDecimal price;
    private String duration;
    private ServiceCategory serviceCategory;

}
