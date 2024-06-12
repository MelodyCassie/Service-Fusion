package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.data.models.Image;
import com.serviceFusion.Capstone.data.repositories.ImageRepository;
import com.serviceFusion.Capstone.dtos.responses.UploadImageResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageServiceApp implements ImageService {
    private final ImageRepository imageRepository;

    @Override
    public Image saveImage(UploadImageResponse response) {

        Image image = new Image();
        image.setImageUrl(response.getUrl());
        imageRepository.save(image);
        return image;
    }
}
