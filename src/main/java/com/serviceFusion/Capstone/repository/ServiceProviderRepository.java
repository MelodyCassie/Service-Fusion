package com.serviceFusion.Capstone.repository;

import com.serviceFusion.Capstone.data.models.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {

    boolean existsByEmail(String email);

}
