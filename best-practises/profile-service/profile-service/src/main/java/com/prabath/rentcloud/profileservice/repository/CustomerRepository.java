package com.prabath.rentcloud.profileservice.repository;

import com.prabath.rentcloud.commons.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer>  {
}
