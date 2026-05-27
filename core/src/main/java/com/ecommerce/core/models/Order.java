package com.ecommerce.core.models;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    
    @ManyToOne
    private Product product;
    private Integer quantity;

    // Construtores
    public Order() {}
    public Order(Long userId, Product product, Integer quantity) {
        this.userId = userId;
        this.product = product;
        this.quantity = quantity;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Integer getQuantity() { return quantity; }
}