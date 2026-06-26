package com.example.supplify.consumer;

import com.example.supplify.event.OrderEvent;
import com.example.supplify.service.InventoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    private final InventoryService inventoryService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public OrderConsumer(
            InventoryService inventoryService) {

        this.inventoryService = inventoryService;
    }

    @KafkaListener(
            topics = "order-topic",
            groupId = "inventory-group"
    )
    public void consume(String message) {

        try {

            OrderEvent event =
                    objectMapper.readValue(
                            message,
                            OrderEvent.class);

            System.out.println(
                    "Received Order : "
                            + event.getOrderId());

            inventoryService.updateInventory(event);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}