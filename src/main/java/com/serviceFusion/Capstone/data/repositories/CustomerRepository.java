package com.serviceFusion.Capstone.data.repositories;

import com.serviceFusion.Capstone.data.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String email);
}
