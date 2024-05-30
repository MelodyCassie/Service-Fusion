package com.serviceFusion.Capstone.dtos.responses;

import com.serviceFusion.Capstone.data.models.ServiceProvider;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SearchServiceProviderResponse {

    List<ServiceProvider> serviceProviders;
}
