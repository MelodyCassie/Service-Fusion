package com.serviceFusion.Capstone.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.serviceFusion.Capstone.dtos.requests.UploadImageRequest;
import com.serviceFusion.Capstone.dtos.responses.UploadImageResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
@AllArgsConstructor
public class CloudinaryImageServiceApp implements CloudinaryImageService{


    private final Cloudinary cloudinary;

    @Override
    public UploadImageResponse uploadImage(UploadImageRequest imageRequest) throws IOException {

        UploadImageResponse response = new UploadImageResponse();
            Map uploadedResult = cloudinary.uploader().upload(imageRequest.getImage().getBytes(), ObjectUtils.emptyMap());
            String url = uploadedResult.get("url").toString();
        response.setUrl(url);
        return response;

    }
}
