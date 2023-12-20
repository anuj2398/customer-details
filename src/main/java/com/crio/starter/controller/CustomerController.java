package com.crio.starter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.crio.starter.data.Customer;
import com.crio.starter.exchange.CustomerDetailsRequest;
import com.crio.starter.service.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/test/{name}")
    public String test(@PathVariable String name) {
        return new String("Hello "+name);
    }
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody CustomerDetailsRequest req) {
        try{
            customerService.addCustomer(req);
            return new ResponseEntity<>("Customer Added Successfully..",HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> get() {
        List<Customer> customerList=customerService.getAll();
        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }
    @GetMapping("/get/{customerId}")
    public ResponseEntity<Customer> getById(@PathVariable String customerId) {
        Customer cId=customerService.getById(customerId);
        if(cId!=null){
            return new ResponseEntity<>(cId,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{customerId}")
    public ResponseEntity<String> update(@PathVariable String customerId, @RequestBody CustomerDetailsRequest req) {
        try {
                customerService.updateCustomer(customerId,req);
                return new ResponseEntity<>("Customer Data Successfully Updated...",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<String> delete(@PathVariable String customerId){
        try {
            customerService.delete(customerId);
            return new ResponseEntity<>("Customer with CustomerID:"+customerId+" deleted Successfully.",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    
}
}
