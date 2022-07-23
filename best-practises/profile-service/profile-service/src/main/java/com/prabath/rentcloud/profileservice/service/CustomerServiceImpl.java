package com.prabath.rentcloud.profileservice.service;

import com.prabath.rentcloud.commons.model.Customer;
import com.prabath.rentcloud.profileservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
