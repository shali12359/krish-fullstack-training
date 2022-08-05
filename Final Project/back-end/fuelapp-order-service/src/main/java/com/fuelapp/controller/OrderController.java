package com.fuelapp.controller;

import com.fuelapp.models.Order;
import com.fuelapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    OrderService OrderService;

    // CREATE ORDER: ROUTE
    @PostMapping("/create")
    public Order saveOrder(@RequestBody Order order) {
        return OrderService.saveOrder(order);
    }

    // GET ORDER BY ID: ROUTE
    @GetMapping("/{id}")
    public Order getStatus(@PathVariable int id) {
        return OrderService.findById(id);
    }

    // GET ALL ORDERS: ROUTE
    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return OrderService.getOrderList();
    }
}
