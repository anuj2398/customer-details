package com.crio.starter.service;


import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crio.starter.data.Customer;
import com.crio.starter.enums.CustomerGroup;
import com.crio.starter.enums.Occupation;
import com.crio.starter.exception.AgeBelow18Exception;
import com.crio.starter.exception.CustomerNotFoundException;
import com.crio.starter.exchange.CustomerDetailsRequest;
import com.crio.starter.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(CustomerDetailsRequest req) {
        if(isBelow18Years(req.getDob())){
            throw new AgeBelow18Exception("Age is below 18");
        }
        Occupation occupation = req.getOccupation();
        if(req.getEmail().endsWith("@hikeon.tech")){
            req.setCustomerGroup(CustomerGroup.HIKEON);
        }
        else if (occupation.equals(Occupation.DEVELOPER)) {
            req.setCustomerGroup(CustomerGroup.DEVELOPER);
        }
        else if(occupation.equals(Occupation.CHEF)){
            req.setCustomerGroup(CustomerGroup.CHEF);
        }
        else {
            req.setCustomerGroup(CustomerGroup.NA);
        }
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

    public Customer updateCustomer(String customerId,CustomerDetailsRequest req) {
        if(isBelow18Years(req.getDob())){
            throw new AgeBelow18Exception("Age is below 18");
        }
        Occupation occupation = req.getOccupation();
        if(req.getEmail().endsWith("@hikeon.tech")){
            req.setCustomerGroup(CustomerGroup.HIKEON);
        }
        else if (occupation.equals(Occupation.DEVELOPER)) {
            req.setCustomerGroup(CustomerGroup.DEVELOPER);
        }
        else if(occupation.equals(Occupation.CHEF)){
            req.setCustomerGroup(CustomerGroup.CHEF);
        }
        else {
            req.setCustomerGroup(CustomerGroup.NA);
        }
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();
            existingCustomer.setName(req.getName());
            existingCustomer.setEmail(req.getEmail());
            existingCustomer.setDob(req.getDob());
            existingCustomer.setCustomerGroup(req.getCustomerGroup());
            existingCustomer.setOccupation(req.getOccupation());
            customerRepository.save(existingCustomer);
            return existingCustomer;
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
    private boolean isBelow18Years(String dob) {
    // Implement proper date of birth validation logic to determine if the customer is below 18 years old
    // This is a placeholder; you should use a date library or convert the string to a date object for accurate validation
    // For simplicity, let's assume the date of birth is in the format "yyyy-MM-dd"
    // and calculate age based on the current date
    // Note: You may want to handle exceptions and edge cases in a real-world scenario
    LocalDate birthDate = LocalDate.parse(dob);
    LocalDate currentDate = LocalDate.now();
    Period age = Period.between(birthDate, currentDate);
    return age.getYears() < 18;  
    }
    // private void validateAndAssignCustomerGroup(CustomerDetailsRequest request) {
    
    //     // Assign customer group based on email domain
    //     if (request.getEmail().contains("hikeon")) {
    //         request.setCustomerGroup(CustomerGroup.HIKEON);
    //     }
    
    //     // Assign customer group based on occupation
    //     Occupation occupation = request.getOccupation();
    //     if (occupation.equals(Occupation.DEVELOPER)) {
    //         request.setCustomerGroup(CustomerGroup.DEVELOPER);
    //     }
    //     else if(occupation.equals(Occupation.CHEF)){
    //         request.setCustomerGroup(CustomerGroup.CHEF);
    //     }
    //     else {
    //         request.setCustomerGroup(CustomerGroup.NA);
    //     }
    //     // You can add additional rules based on your requirements
    
    //     // For customers below 18 years old, throw an error
    //     // Note: This is just a placeholder; you should implement proper date of birth validation
    //     // in a real-world scenario
    //     if (isBelow18Years(request.getDob())) {
    //         throw new AgeBelow18Exception("Customers below 18 years old are not allowed.");
    //     }
    // }
}
