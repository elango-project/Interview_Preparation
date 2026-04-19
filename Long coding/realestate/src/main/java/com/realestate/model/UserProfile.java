package com.realestate.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserProfile {

    @Id
    @GeneratedValue
    private Long id;

    private double monthlyIncome;
    private double savings;
    private double maxBudget;

    private double preferredDownPayment; // %
    private double riskTolerance; // 0 (safe) to 1 (aggressive)

    private String preferredLocation;
}
