package com.serviceFusion.Capstone.paymentTest;

import com.serviceFusion.Capstone.dtos.requests.PaymentRequest;
import com.serviceFusion.Capstone.dtos.responses.PaymentResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;
import com.serviceFusion.Capstone.services.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PaymentTest {

    @Autowired
    private PaymentService paymentService;

    @Test
    public void testThatABookingCanBePaidFor() throws ServiceFusionException {
        PaymentRequest request = new PaymentRequest();
        request.setBookingId(1L);
        request.setCustomerId(1L);
        request.setAmount(BigDecimal.valueOf(5000));

        PaymentResponse response = paymentService.payForBooking(request);
        assertThat(response).isNotNull();

    }
}
