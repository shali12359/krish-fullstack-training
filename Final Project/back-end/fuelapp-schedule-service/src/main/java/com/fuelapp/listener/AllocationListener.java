package com.fuelapp.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuelapp.models.Allocation;
import com.fuelapp.models.Order;
import com.fuelapp.models.Schedule;
import com.fuelapp.repository.CustomOrderRepo;
import com.fuelapp.repository.OrderRepo;
import com.fuelapp.repository.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AllocationListener {
    @Autowired
    ScheduleRepo scheduleRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    CustomOrderRepo customOrderRepo;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    ObjectMapper mapper = new ObjectMapper();
    ObjectMapper mapper2 = new ObjectMapper();

    @Value("${dispatch.topic.name}")
    private String topicName;

    @KafkaListener(topics = "allocation-topic", groupId = "groupId")
    public void processAllocation(String allocationStr) {
        System.out.println("Received to Schedule: " + allocationStr);

        // ALLOCATE A DISPATCH DATE
        Random randomDays = ThreadLocalRandom.current();
        LocalDateTime date = LocalDateTime.now().plusDays(randomDays.nextInt(7) + 1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDate today = LocalDate.now();

        try {
            // READ CREATED ALLOCATION DETAILS FROM KAFKA
            Allocation allocation = mapper.readValue(allocationStr, Allocation.class);

            System.out.println("Allocation: " + allocation.getOrderId());
            Order updateOrder = customOrderRepo.findByOrderId(allocation.getOrderId());

            // SAVE DELIVERY SCHEDULE
            Schedule schedule = new Schedule();
            schedule.setOrderId(allocation.getOrderId());
            scheduleRepo.save(schedule);

            // WRITE SCHEDULE TO KAFKA
            String dispatchStr = mapper2.writeValueAsString(schedule);
            kafkaTemplate.send(topicName, dispatchStr);

            // UPDATE ORDER DISPATCH DATE
            updateOrder.setDispatchDate(dtf.format(date));
            orderRepo.save(updateOrder);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
