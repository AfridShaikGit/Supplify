package com.example.supplify.event;

import java.math.BigDecimal;

public class OrderEvent {

    private Long orderId;
    private String customerName;
    private String productName;
    private Integer quantity;
    private BigDecimal amount;

    public OrderEvent() {
    }

    public OrderEvent(Long orderId,
                      String customerName,
                      String productName,
                      Integer quantity,
                      BigDecimal amount) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}