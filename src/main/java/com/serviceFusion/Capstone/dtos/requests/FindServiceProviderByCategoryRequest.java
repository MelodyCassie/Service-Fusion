package com.serviceFusion.Capstone.dtos.requests;

import com.serviceFusion.Capstone.data.models.ServiceCategory;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FindServiceProviderByCategoryRequest {
    private ServiceCategory category;
}
