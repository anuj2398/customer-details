package com.crio.starter.data;

import org.springframework.data.mongodb.core.mapping.Document;

import com.crio.starter.enums.CustomerGroup;
import com.crio.starter.enums.Occupation;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document("CustomerDetails")
@Data
@NoArgsConstructor
public class Customer {
    private String id;
    private String name;
    private String email;
    private String dob;
    private Occupation occupation;
    private CustomerGroup customerGroup;

    public Customer(String name,String email,String dob,Occupation occupation,CustomerGroup customerGroup){
        this.name=name;
        this.email=email;
        this.dob=dob;
        this.occupation=occupation;
        this.customerGroup=customerGroup;
    }
}
