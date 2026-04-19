package com.realestate.dto;

import java.util.List;

public class PropertyAnalysisResponse {

    private Long propertyId;
    private String title;
    private Double monthlyCost;
    private int affordabilityScore;
    private int trustScore;
    private int finalScore;
    private List<String> insights;

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(Double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public int getAffordabilityScore() {
        return affordabilityScore;
    }

    public void setAffordabilityScore(int affordabilityScore) {
        this.affordabilityScore = affordabilityScore;
    }

    public int getTrustScore() {
        return trustScore;
    }

    public void setTrustScore(int trustScore) {
        this.trustScore = trustScore;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public List<String> getInsights() {
        return insights;
    }

    public void setInsights(List<String> insights) {
        this.insights = insights;
    }
}