package com.realestate.dto;

public class AnalysisRequest {

    private Double monthlyIncome;
    private Double savings;
    private Double downPaymentPercent;
    private Double interestRate;
    private Double riskTolerance;

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public double getDownPaymentPercent() {
        return downPaymentPercent;
    }

    public void setDownPaymentPercent(double downPaymentPercent) {
        this.downPaymentPercent = downPaymentPercent;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getRiskTolerance() {
        return riskTolerance;
    }

    public void setRiskTolerance(double riskTolerance) {
        this.riskTolerance = riskTolerance;
    }
}
