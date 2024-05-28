package com.serviceFusion.Capstone.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminDeleteServiceProviderRequest {
    private Long adminId;
    private Long serviceProviderId;
}
