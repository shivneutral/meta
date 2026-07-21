package com.example.meta.controller;

import com.example.meta.entity.Customer;
import com.example.meta.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CustomerControllerTest {

    @Test
    void shouldReturnAllCustomers() throws Exception {
        CustomerService customerService = mock(CustomerService.class);
        CustomerController customerController = new CustomerController(customerService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Jane Doe");
        customer.setEmail("jane@example.com");

        when(customerService.getAllCustomers()).thenReturn(List.of(customer));

        mockMvc.perform(get("/api/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Jane Doe"));
    }
}
