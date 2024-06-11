package com.serviceFusion.Capstone.data.repositories;

import com.serviceFusion.Capstone.data.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
