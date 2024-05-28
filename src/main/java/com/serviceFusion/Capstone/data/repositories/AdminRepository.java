package com.serviceFusion.Capstone.data.repositories;

import com.serviceFusion.Capstone.data.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);
}
