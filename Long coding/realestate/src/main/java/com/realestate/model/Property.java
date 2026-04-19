package com.realestate.model;

import jakarta.persistence.*;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private double currentPrice;
    private double lastSoldPrice;

    private double monthlyTax;
    private double hoaFees;

    private String description;
    

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public double getLastSoldPrice() {
        return lastSoldPrice;
    }

    public double getMonthlyTax() {
        return monthlyTax;
    }

    public double getHoaFees() {
        return hoaFees;
    }

    public String getDescription() {
        return description;
    }
}