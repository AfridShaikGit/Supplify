package com.example.supplify.service;

import com.example.supplify.event.OrderEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public KafkaProducerService(
            KafkaTemplate<String, OrderEvent> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderEvent(OrderEvent event) {

        kafkaTemplate.send(
                "order-topic",
                event
        );

        System.out.println(
                "Order Event Published : "
                        + event.getOrderId()
        );
    }
}