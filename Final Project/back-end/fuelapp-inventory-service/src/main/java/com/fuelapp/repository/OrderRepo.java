package com.fuelapp.repository;

import org.springframework.data.repository.CrudRepository;
import com.fuelapp.models.Order;

public interface OrderRepo extends CrudRepository<Order, Integer> {
}
