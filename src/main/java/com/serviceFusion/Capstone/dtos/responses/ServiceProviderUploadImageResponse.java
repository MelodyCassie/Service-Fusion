package com.serviceFusion.Capstone.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServiceProviderUploadImageResponse {
    private Long imageId;
    private String imageUrl;
}
