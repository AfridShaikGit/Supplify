package com.example.supplify.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long orderID;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "amount")
    private BigDecimal amount;

    public Order() {
    }

    public Order(Long orderID,
                 String customerName,
                 String productName,
                 Integer quantity,
                 BigDecimal amount) {

        this.orderID = orderID;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
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