package com.fuelapp.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuelapp.models.Allocation;
import com.fuelapp.models.Order;
import com.fuelapp.models.Stock;
import com.fuelapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderListener {
    double availableStock = 0;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    StockRepo stockRepo;

    @Autowired
    AllocationRepo allocationRepo;

    @Autowired
    CustomStockRepo customRepo;

    @Autowired
    CustomOrderRepo customOrderRepo;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    ObjectMapper mapper = new ObjectMapper();
    ObjectMapper mapper2 = new ObjectMapper();

    @Value("${allocation.topic.name}")
    private String topicName;

    // LISTEN TO KAFKA: METHOD
    @KafkaListener(topics = "order-topic", groupId = "groupId")
    public void processOrder(String orderStr) {
        System.out.println("Received to Inventory: " + orderStr);

        try {
            // READ CREATED ORDER DETAILS FROM KAFKA
            Order order = mapper.readValue(orderStr, Order.class);

            // GET STOCK FUEL AMOUNT FOR ORDERED STATION
            Stock stock = customRepo.findByStationId(order.getStationId(), order.getType());
            Order updateOrder = customOrderRepo.findByOrderId(order.getOrderId());

            Allocation allocation = new Allocation();

            // CHECK STATION FUEL AMOUNT
            if (stock.getAmount() > order.getAmount()) {
                // REDUCE ORDER FUEL AMOUNT FROM STOCK
                availableStock = stock.getAmount() - order.getAmount();
                allocation.setOrderId(order.getOrderId());
                // SAVE ORDER ALLOCATION
                allocationRepo.save(allocation);


                // WRITE ALLOCATION TO KAFKA
                String allocationStr = mapper2.writeValueAsString(allocation);
                kafkaTemplate.send(topicName, allocationStr);
                System.out.println("allocationStr: " + allocationStr);

                // SET ORDER STATUS
                updateOrder.setStatus("Allocated");

//                System.out.println("Stock: " + stock.getAmount());
//                System.out.println("Available: " + availableStock);

                // UPDATE AVAILABLE STOCK
                stock.setAmount(availableStock);
                stockRepo.save(stock);
            }
            else {
                updateOrder.setStatus("Not Allocated");
            }
            // UPDATE ORDER STATUS
            orderRepo.save(updateOrder);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
