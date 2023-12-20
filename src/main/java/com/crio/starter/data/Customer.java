package com.crio.starter.data;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("CustomerDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String id;
    private String name;
    private String email;
    private String dob;
    private String occupation;
    private String customerGroup;
}
