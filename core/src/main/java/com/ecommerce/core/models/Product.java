package com.ecommerce.core.models;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer stock;

    // Construtores
    public Product() {}
    public Product(String name, Integer stock) { this.name = name; this.stock = stock; }

    // Getters e Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
}