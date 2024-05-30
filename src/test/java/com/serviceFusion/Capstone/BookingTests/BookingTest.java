//package com.serviceFusion.Capstone.BookingTests;
//
//import com.serviceFusion.Capstone.dtos.requests.BookingRequest;
//import com.serviceFusion.Capstone.dtos.responses.BookingResponse;
//import com.serviceFusion.Capstone.services.BookingService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//public class BookingTest {
//
//    @Autowired
//    private BookingService bookingService;
//
//    @Test
//    public void testThatServiceCanBeBooked() {
//        BookingRequest request = new BookingRequest();
//        request.setCustomerId(1L);
//        request.setServiceId(1L);
//        request.setServiceProviderId(1L);
//        request.setBookingDate(LocalDateTime.now());
//        BookingResponse response = bookingService.bookService(request);
//        assertThat(response).isNotNull();
//    }
//}
