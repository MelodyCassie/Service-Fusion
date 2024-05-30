package com.serviceFusion.Capstone.data.repositories;

import com.serviceFusion.Capstone.data.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
