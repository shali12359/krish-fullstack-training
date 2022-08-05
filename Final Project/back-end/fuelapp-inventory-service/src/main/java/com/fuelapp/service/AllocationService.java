package com.fuelapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuelapp.models.Order;
import com.fuelapp.models.Stock;
import com.fuelapp.repository.OrderRepo;
import com.fuelapp.repository.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AllocationService {
}
