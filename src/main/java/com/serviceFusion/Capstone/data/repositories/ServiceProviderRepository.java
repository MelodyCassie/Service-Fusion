package com.serviceFusion.Capstone.data.repositories;

import com.serviceFusion.Capstone.data.models.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {

    boolean existsByEmail(String email);

    ServiceProvider findByEmail(String email);

}
