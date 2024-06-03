package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.dtos.requests.UploadImageRequest;
import com.serviceFusion.Capstone.dtos.responses.UploadImageResponse;

import java.io.IOException;

public interface CloudinaryImageService {
    UploadImageResponse uploadImage(UploadImageRequest request) throws IOException;
}
