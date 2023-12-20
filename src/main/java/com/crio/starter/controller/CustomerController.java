package com.crio.starter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.crio.starter.exchange.CustomerDetailsRequest;
import com.crio.starter.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @GetMapping("/test")
    public String test(@PathVariable String name) {
        return new String("Hello "+name);
    }
    @PostMapping("path")
    public ResponseEntity<String> postMethodName(@RequestBody CustomerDetailsRequest req) {
        try{
            customerService.addCustomer(req);
            return new ResponseEntity<>("Customer Added Successfully..",HttpStatus.ACCEPTED);
        }catch{
            
        }
    }
    
    
}
