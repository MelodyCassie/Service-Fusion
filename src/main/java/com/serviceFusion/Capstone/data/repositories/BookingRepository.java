package com.serviceFusion.Capstone.data.repositories;

import com.serviceFusion.Capstone.data.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
