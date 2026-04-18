package com.realestate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private double currentPrice;
    private double lastSoldPrice;
    private int monthsSinceLastSale;
    private double monthlyHoaFee;
    private double annualPropertyTax;
    private String redFlagKeywords;

    // Getters
    public Long getId() { return id; }
    public String getAddress() { return address; }
    public double getCurrentPrice() { return currentPrice; }
    public double getLastSoldPrice() { return lastSoldPrice; }
    public int getMonthsSinceLastSale() { return monthsSinceLastSale; }
    public double getMonthlyHoaFee() { return monthlyHoaFee; }
    public double getAnnualPropertyTax() { return annualPropertyTax; }
    public String getRedFlagKeywords() { return redFlagKeywords; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setAddress(String address) { this.address = address; }
    public void setCurrentPrice(double currentPrice) { this.currentPrice = currentPrice; }
    public void setLastSoldPrice(double lastSoldPrice) { this.lastSoldPrice = lastSoldPrice; }
    public void setMonthsSinceLastSale(int monthsSinceLastSale) { this.monthsSinceLastSale = monthsSinceLastSale; }
    public void setMonthlyHoaFee(double monthlyHoaFee) { this.monthlyHoaFee = monthlyHoaFee; }
    public void setAnnualPropertyTax(double annualPropertyTax) { this.annualPropertyTax = annualPropertyTax; }
    public void setRedFlagKeywords(String redFlagKeywords) { this.redFlagKeywords = redFlagKeywords; }
}