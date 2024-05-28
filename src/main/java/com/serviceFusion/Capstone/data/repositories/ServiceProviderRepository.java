package com.serviceFusion.Capstone.data.repositories;

import com.serviceFusion.Capstone.data.models.Location;
import com.serviceFusion.Capstone.data.models.ServiceCategory;
import com.serviceFusion.Capstone.data.models.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {

    boolean existsByEmail(String email);

    ServiceProvider findByEmail(String email);

    ServiceProvider findByServiceCategory(ServiceCategory serviceCategory);

    ServiceProvider findByLocation(Location location);
}
