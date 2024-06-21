package com.example.Stock.Stock.Entities;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "stocks")
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    // Constructors, getters, and setters
    public Stock() {
    }

    public Stock(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


