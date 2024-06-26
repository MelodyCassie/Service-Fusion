package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.configs.PayStackConfig;
import com.serviceFusion.Capstone.data.models.Customer;
import com.serviceFusion.Capstone.data.models.Payment;
import com.serviceFusion.Capstone.data.repositories.CustomerRepository;
import com.serviceFusion.Capstone.data.repositories.PaymentRepository;
import com.serviceFusion.Capstone.dtos.requests.InitializeTransactionRequest;
import com.serviceFusion.Capstone.dtos.requests.PaymentRequest;
import com.serviceFusion.Capstone.dtos.responses.PayStackTransactionResponse;
import com.serviceFusion.Capstone.dtos.responses.PaymentResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PaymentServiceApp implements PaymentService {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private PaymentRepository paymentRepository;
    private PayStackConfig config;

    @Override
    public PaymentResponse payForBooking(PaymentRequest request) throws ServiceFusionException {
        Customer existingCustomer = customerRepository.findByEmail(request.getCustomerEmail());
        if (existingCustomer == null) throw new ServiceFusionException("Customer not found");
        List<Payment> customerListOfPayment = existingCustomer.getPayments();
        Payment payment = new Payment();
        payment.setCustomerId(request.getCustomerId());
        payment.setBookingId(request.getBookingId());
        payment.setAmount(request.getAmount());
        payment.setPaymentDate(LocalDateTime.now());


        customerListOfPayment.add(payment);
        existingCustomer.setPayments(customerListOfPayment);
        customerService.save(existingCustomer);
        paymentRepository.save(payment);

        PaymentResponse response = new PaymentResponse();
        response.setPaymentId(payment.getId());
        response.setMessage("Payment successful");

        RestTemplate template = new RestTemplate();
        HttpEntity<InitializeTransactionRequest> transactionRequest = buildPayment(existingCustomer, payment);

        ResponseEntity<PayStackTransactionResponse> transactionResponseResponse =
                template.postForEntity(config.getPayStackBaseUrl(),transactionRequest,PayStackTransactionResponse.class);

        System.out.println(transactionResponseResponse.getBody().getTransactionDetails().getAuthorizationUrl());

        return response;

    }

    private HttpEntity<InitializeTransactionRequest> buildPayment(Customer existingCustomer, Payment payment) {
        InitializeTransactionRequest request = new InitializeTransactionRequest();
        request.setEmail(existingCustomer.getEmail());
        request.setAmount(String.valueOf(payment.getAmount().multiply(BigDecimal.valueOf(100))));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + config.getPayStackApiKey());
        return new HttpEntity<>(request, headers);
    }


}