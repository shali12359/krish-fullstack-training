package com.fuelapp.repository;

import com.fuelapp.models.Allocation;
import org.springframework.data.repository.CrudRepository;

public interface AllocationRepo extends CrudRepository<Allocation, Integer> {
}
