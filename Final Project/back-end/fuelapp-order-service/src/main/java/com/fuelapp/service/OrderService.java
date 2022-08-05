package com.fuelapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuelapp.models.Order;
import com.fuelapp.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    ObjectMapper mapper = new ObjectMapper();

    // SET KAFKA TOPIC
    @Value("${order.topic.name}")
    private String topicName;

    // SAVE ORDER: SERVICE METHOD
    public Order saveOrder(Order order) {
        // SAVE ORDER
        order = orderRepo.save(order);

        try {
            // WRITE ORDER DETAILS
            String orderStr = mapper.writeValueAsString(order);
            // EMMIT ORDER DETAILS TO KAFKA
            kafkaTemplate.send(topicName, orderStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return order;
    }

    // GET ORDER BY ID: SERVICE METHOD
    public Order findById(int id) {
        Optional<Order> order = orderRepo.findById(id);

        if (order.isPresent())
            return order.get();
        else
            return new Order();
    }

    // GET ALL ORDERS: SERVICE METHOD
    public List<Order> getOrderList() {
        List<Order> orders = (List<Order>) orderRepo.findAll();

        return orders;
    }
}
