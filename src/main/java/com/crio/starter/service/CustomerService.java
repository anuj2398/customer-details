package com.crio.starter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.starter.data.Customer;
import com.crio.starter.exception.CustomerNotFoundException;
import com.crio.starter.exchange.CustomerDetailsRequest;
import com.crio.starter.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(CustomerDetailsRequest req) {
        Customer customer=new Customer(req.getName(), req.getEmail(), req.getDob(), req.getOccupation(), req.getCustomerGroup());
        customerRepository.save(customer);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer getById(String customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        return optionalCustomer.orElse(null);
    }

    public void updateCustomer(String customerId, CustomerDetailsRequest req) {
        validateAndAssignCustomerGroup(req);
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();
            existingCustomer.setName(req.getName());
            existingCustomer.setEmail(req.getEmail());
            existingCustomer.setDob(req.getDob());
            existingCustomer.setCustomerGroup(req.getCustomerGroup());
            existingCustomer.setOccupation(req.getOccupation());
        }else{
            throw new CustomerNotFoundException("Customer with ID:"+customerId+" not found");
        }
    }

    public void delete(String customerId) {
        Optional<Customer> c=customerRepository.findById(customerId);
        if(c.isPresent()){
            customerRepository.deleteById(customerId);
        }else{
            throw new CustomerNotFoundException("Customer with ID:"+customerId+" not found");
        }
    }

    
}
