package com.crio.starter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.crio.starter.data.Customer;
import com.crio.starter.exchange.CustomerDetailsRequest;
import com.crio.starter.service.CustomerService;

public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddCustomer() {
        // Arrange
        CustomerDetailsRequest request = new CustomerDetailsRequest();
        doNothing().when(customerService).addCustomer(request);

        // Act
        ResponseEntity<String> response = customerController.add(request);

        // Assert
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals("Customer Added Successfully..", response.getBody());
    }

    @Test
    public void testGetAllCustomers() {
        // Arrange
        List<Customer> customerList = Collections.singletonList(new Customer());
        when(customerService.getAll()).thenReturn(customerList);

        // Act
        ResponseEntity<List<Customer>> response = customerController.get();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customerList, response.getBody());
    }

    @Test
    public void testGetCustomerById() {
        // Arrange
        String customerId = "123";
        Customer customer = new Customer();
        when(customerService.getById(customerId)).thenReturn(customer);

        // Act
        ResponseEntity<Customer> response = customerController.getById(customerId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    public void testUpdateCustomer() {
        // Arrange
        String customerId = "123";
        CustomerDetailsRequest request = new CustomerDetailsRequest();
        Customer updatedCustomer = new Customer();
        when(customerService.updateCustomer(customerId, request)).thenReturn(updatedCustomer);

        // Act
        ResponseEntity<Customer> response = customerController.update(customerId, request);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedCustomer, response.getBody());
    }

    @Test
    public void testDeleteCustomer() {
        // Arrange
        String customerId = "123";
        doNothing().when(customerService).delete(customerId);

        // Act
        ResponseEntity<String> response = customerController.delete(customerId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Customer with CustomerID:123 deleted Successfully.", response.getBody());
    }
}