package com.crio.starter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crio.starter.data.Customer;

public interface CustomerRepository extends MongoRepository<Customer,String>{

}
