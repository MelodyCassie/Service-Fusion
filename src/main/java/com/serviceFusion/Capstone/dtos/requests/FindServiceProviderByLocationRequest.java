package com.serviceFusion.Capstone.dtos.requests;

import com.serviceFusion.Capstone.data.models.Location;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FindServiceProviderByLocationRequest {
    private Location location;
}
