package com.crio.starter.exchange;

import com.crio.starter.enums.CustomerGroup;
import com.crio.starter.enums.Occupation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetailsRequest {
    private String name;
    private String email;
    private String dob;
    private Occupation occupation;
    private CustomerGroup customerGroup;
}
