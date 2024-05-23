package com.serviceFusion.Capstone.repository;

import com.serviceFusion.Capstone.data.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
