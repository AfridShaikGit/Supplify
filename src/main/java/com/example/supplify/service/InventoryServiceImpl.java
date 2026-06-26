package com.example.supplify.service;


import com.example.supplify.entity.Inventory;
import com.example.supplify.event.OrderEvent;
import com.example.supplify.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(
            InventoryRepository inventoryRepository) {

        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public void updateInventory(OrderEvent event) {

        Inventory inventory = inventoryRepository
                .findByProductName(event.getProductName())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Product not found : "
                                        + event.getProductName()));

        Integer availableQuantity = inventory.getQuantity();

        Integer orderedQuantity = event.getQuantity();

        if (availableQuantity < orderedQuantity) {
            throw new RuntimeException(
                    "Insufficient inventory for product : "
                            + event.getProductName());
        }

        inventory.setQuantity(
                availableQuantity - orderedQuantity
        );

        inventoryRepository.save(inventory);

        System.out.println(
                "Inventory updated successfully for product : "
                        + event.getProductName());
    }
}