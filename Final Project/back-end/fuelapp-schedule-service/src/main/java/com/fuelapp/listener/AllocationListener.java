package com.fuelapp.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AllocationListener {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    ObjectMapper mapper = new ObjectMapper();

    @Value("${allocation.topic.name}")
    private String topicName;

    @KafkaListener(topics = "allocation-topic", groupId = "groupId")
    public void processAllocation(String allocationStr) {
        System.out.println("Received to Schedule: " + allocationStr);

    }
}
