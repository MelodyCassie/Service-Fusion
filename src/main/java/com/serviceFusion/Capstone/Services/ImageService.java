package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.data.models.Image;
import com.serviceFusion.Capstone.dtos.responses.UploadImageResponse;

public interface ImageService {
    Image saveImage(UploadImageResponse response);
}
