package com.fuelapp.repository;

import com.fuelapp.models.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepo extends CrudRepository<Stock, Integer> {
}
