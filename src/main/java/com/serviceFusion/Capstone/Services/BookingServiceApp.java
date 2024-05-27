package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.data.models.Booking;
import com.serviceFusion.Capstone.dtos.requests.BookingRequest;
import com.serviceFusion.Capstone.dtos.responses.BookingResponse;
import com.serviceFusion.Capstone.data.repositories.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingServiceApp implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public BookingResponse bookService(BookingRequest request) {
        Booking booking = new Booking();
        booking.setCustomerId(request.getCustomerId());
        booking.setServiceProviderId(request.getServiceProviderId());
        booking.setServiceId(request.getServiceId());
        booking.setBookingDate(request.getBookingDate());
        bookingRepository.save(booking);

        BookingResponse response = new BookingResponse();
        response.setBookingId(booking.getId());
        response.setBookingDate(String.valueOf(booking.getBookingDate()));
        response.setMessage("Booking successful");

        return response;

    }
}
