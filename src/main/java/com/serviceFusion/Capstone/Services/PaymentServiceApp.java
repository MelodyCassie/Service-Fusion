package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.data.models.Booking;
import com.serviceFusion.Capstone.data.models.Customer;
import com.serviceFusion.Capstone.data.models.Payment;
import com.serviceFusion.Capstone.data.repositories.CustomerRepository;
import com.serviceFusion.Capstone.data.repositories.PaymentRepository;
import com.serviceFusion.Capstone.dtos.requests.PaymentRequest;
import com.serviceFusion.Capstone.dtos.responses.PaymentResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PaymentServiceApp implements PaymentService{
    private final CustomerRepository customerRepository;
    private PaymentRepository paymentRepository;
    @Override
    public PaymentResponse payForBooking(PaymentRequest request) throws ServiceFusionException {
        Customer existingCustomer = customerRepository.findById(request.getBookingId()).orElse(null);
        if (existingCustomer == null) throw new ServiceFusionException("Customer not found");

        Payment payment = new Payment();
        payment.setCustomerId(request.getCustomerId());
        payment.setBookingId(request.getBookingId());
        payment.setAmount(request.getAmount());
        payment.setPaymentDate(LocalDateTime.now());
        paymentRepository.save(payment);

        List<Payment> payments = new ArrayList<>();
        payments.add(payment);
        existingCustomer.setPayments(payments);
        customerRepository.save(existingCustomer);
        PaymentResponse response = new PaymentResponse();
        response.setPaymentId(payment.getId());
        response.setMessage("Payment successful");

        return response;
    }
}
