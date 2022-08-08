package com.fuelapp.repository;

import com.fuelapp.models.Order;
import com.fuelapp.models.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepo extends CrudRepository<Schedule, Integer> {
}
