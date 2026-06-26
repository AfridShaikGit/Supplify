package com.example.supplify.service;

import com.example.supplify.entity.Order;
import com.example.supplify.event.OrderEvent;
import com.example.supplify.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final KafkaProducerService kafkaProducerService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            KafkaProducerService kafkaProducerService) {

        this.orderRepository = orderRepository;
        this.kafkaProducerService = kafkaProducerService;
    }

    @Override
    public Order createOrder(Order order) {

        Order savedOrder = orderRepository.save(order);

        OrderEvent event = new OrderEvent(
                savedOrder.getOrderID(),
                savedOrder.getCustomerName(),
                savedOrder.getProductName(),
                savedOrder.getQuantity(),
                savedOrder.getAmount()
        );

        kafkaProducerService.sendOrderEvent(event);

        return savedOrder;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}