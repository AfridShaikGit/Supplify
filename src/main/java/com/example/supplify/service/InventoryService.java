package com.example.supplify.service;

import com.example.supplify.event.OrderEvent;

public interface InventoryService {

    void updateInventory(OrderEvent event);
}
