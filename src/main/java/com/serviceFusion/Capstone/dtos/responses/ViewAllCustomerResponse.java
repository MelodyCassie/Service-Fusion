package com.serviceFusion.Capstone.dtos.responses;

import com.serviceFusion.Capstone.data.models.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ViewAllCustomerResponse {
    List<Customer> customers;
}
