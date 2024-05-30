package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.data.models.Booking;
import com.serviceFusion.Capstone.data.models.Customer;
import com.serviceFusion.Capstone.data.models.ServiceProvider;
import com.serviceFusion.Capstone.data.repositories.BookingRepository;
import com.serviceFusion.Capstone.data.repositories.CustomerRepository;
import com.serviceFusion.Capstone.dtos.requests.*;
import com.serviceFusion.Capstone.dtos.responses.*;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.serviceFusion.Capstone.utils.Verification.*;
@Service
@AllArgsConstructor

public class CustomerServiceApp implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final BookingRepository bookingRepository;
    private final ServiceProviderService serviceProviderService;

    @Override
    public CustomerRegistrationResponse register(CustomerRegistrationRequest request) throws ServiceFusionException {
        alreadyRegisteredCheck(request);
        verifyDetails(request);
        Customer customer = modelMapper.map((request), Customer.class);
        customer.setCreatedAt(LocalDateTime.now());
        customerRepository.save(customer);

        return response(customer);
    }

    private static CustomerRegistrationResponse response(Customer customer) {
        CustomerRegistrationResponse response = new CustomerRegistrationResponse();
        response.setId(customer.getId());
        response.setMessage("Registered Successfully");
        return response;
    }

    private void alreadyRegisteredCheck(CustomerRegistrationRequest request) throws ServiceFusionException {
        boolean isRegistered  = customerRepository.findByEmail(request.getEmail())!=null;
        if (isRegistered) throw new ServiceFusionException("Registration details already taken");
    }

    private static void verifyDetails(CustomerRegistrationRequest request) throws ServiceFusionException {
        if (request.getFullName().length() < 3) throw new ServiceFusionException("FullName must be at least 3 characters");
        if (request.getUsername().length() < 3) throw new ServiceFusionException("Username must be at least 3 characters");
        if (request.getAddress().length() < 3) throw new ServiceFusionException("Address must be at least 3 characters");
        if (verifyEmail(request.getEmail())) throw new ServiceFusionException("Invalid email format");
        if (verifyPassword(request.getPassword())) throw new ServiceFusionException("Invalid password format");
        if (verifyPhoneNumber(request.getPhoneNumber())) throw new ServiceFusionException("Invalid phoneNumber format");


    }

    @Override
    public CustomerLoginResponse login(CustomerLoginRequest request) throws ServiceFusionException {
        Customer existingCustomer = customerRepository.findByEmail(request.getEmail());
        if (existingCustomer==null) throw new ServiceFusionException("User not found");
        String password = existingCustomer.getPassword();
        if (!password.equals(request.getPassword())) throw new ServiceFusionException("Invalid password");
        existingCustomer.setLoginStatus(true);
        customerRepository.save(existingCustomer);

        CustomerLoginResponse response = new CustomerLoginResponse();
        response.setMessage("Login successful");

        return response;
    }

    @Override
    public CustomerUpdateResponse updateCustomer(CustomerUpdateProfileRequest request) throws ServiceFusionException {
        Customer existingCustomer = customerRepository.findById(request.getCustomerId()).orElse(null);
        if (existingCustomer==null) throw new ServiceFusionException("User not found exception");
        if (!existingCustomer.isLoginStatus()) throw new ServiceFusionException("Kindly login to update your profile");
        modelMapper.map(request, existingCustomer);
        existingCustomer.setUpdatedAt(LocalDateTime.now());

        customerRepository.save(existingCustomer);

        return getUpdateResponse(existingCustomer);



    }

    @Override
    public SearchServiceProviderResponse searchForServiceProvider(SearchServiceProviderRequest request) {
        SearchServiceProviderResponse response = new SearchServiceProviderResponse();
        List<ServiceProvider> providers = serviceProviderService.findByServiceProvideByCategory(request.getCategory());
        List<ServiceProvider> serviceProviders = providers.stream()
                .filter(location -> location.getLocation().equals(request.getLocation())).toList();
        response.setServiceProviders(serviceProviders);
        return response;
    }

    @Override
    public CustomerBookingResponse bookService(CustomerBookingRequest request) throws ServiceFusionException {
        Customer existingCustomer = getExistingCustomer(request);
        if (existingCustomer.isLoginStatus()) throw new ServiceFusionException("Kindly login to book a service");
        Booking booking = getBooking(request);
        bookingRepository.save(booking);
        List<Booking> customerBooking = new ArrayList<>();
        customerBooking.add(booking);
        existingCustomer.setBookings(customerBooking);
        customerRepository.save(existingCustomer);

        return getResponse(booking, existingCustomer);
    }

    private static @NotNull CustomerBookingResponse getResponse(Booking booking, Customer existingCustomer) {
        CustomerBookingResponse response = new CustomerBookingResponse();
        response.setBookingId(booking.getId());
        response.setMessage("Dear " + existingCustomer.getUsername()  + " your booking was successful.");
        return response;
    }

    private static @NotNull Booking getBooking(CustomerBookingRequest request) {
        Booking booking = new Booking();
        booking.setCustomerId(request.getCustomerId());
        booking.setPreferredDate(request.getPreferredDate());
        booking.setCreatedAt(LocalDateTime.now());
        booking.setServiceProviderId(request.getCustomerId());
        return booking;
    }

    @Override
    public Customer findById(Long customerId) {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public void save(Customer existingCustomer) {
        customerRepository.save(existingCustomer);
    }

    @Override
    public ViewAllCustomerBookingResponse viewCustomerBooking(ViewAllCstomerBookingRequest request) {
        Customer existingCustomer = customerRepository.findById(request.getCustomerId()).get();
        List<Booking> allBooking = existingCustomer.getBookings();

        ViewAllCustomerBookingResponse response = new ViewAllCustomerBookingResponse();
        response.setCustomerBooking(allBooking);

        return response;
    }

    private @NotNull Customer getExistingCustomer(CustomerBookingRequest request) throws ServiceFusionException {
        Customer existingCustomer = customerRepository.findById(request.getCustomerId()).orElse(null);
        if (existingCustomer==null) throw new ServiceFusionException("Kindly register to book a service");
        return existingCustomer;
    }

    private static @NotNull CustomerUpdateResponse getUpdateResponse(Customer existingCustomer) {
        CustomerUpdateResponse response = new CustomerUpdateResponse();
        response.setMessage("Updated Successfully");
        response.setCustomerId(existingCustomer.getId());
        return response;
    }
}

