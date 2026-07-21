package com.example.meta.service;

import com.example.meta.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customerDetails);

    void deleteCustomer(Long id);
}
