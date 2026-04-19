package com.realestate.service;

import com.realestate.dto.AnalysisRequest;
import com.realestate.dto.PropertyAnalysisResponse;
import com.realestate.model.Property;
import com.realestate.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyAnalysisService {

    private final PropertyRepository repository;

    public PropertyAnalysisService(PropertyRepository repository) {
        this.repository = repository;
    }

    public List<PropertyAnalysisResponse> analyzeAllProperties(AnalysisRequest request) {

        List<Property> properties = repository.findAll();
        List<PropertyAnalysisResponse> responses = new ArrayList<>();

        for (Property property : properties) {
            responses.add(analyzeProperty(property, request));
        }

        // 🔥 SORT HERE
        responses.sort((a, b) -> Integer.compare(b.getFinalScore(), a.getFinalScore()));

        return responses;
    }

    private PropertyAnalysisResponse analyzeProperty(Property property, AnalysisRequest user) {

        double monthlyCost = calculateMonthlyCost(property, user);

        int affordabilityScore = calculateAffordability(monthlyCost, user.getMonthlyIncome());

        int trustScore = calculateTrustScore(property, user);

        int finalScore = (int) (0.6 * trustScore + 0.4 * affordabilityScore);

        List<String> insights = generateInsights(property, monthlyCost, user);

        PropertyAnalysisResponse res = new PropertyAnalysisResponse();
        res.setPropertyId(property.getId());
        res.setTitle(property.getTitle());
        res.setMonthlyCost(monthlyCost);
        res.setAffordabilityScore(affordabilityScore);
        res.setTrustScore(trustScore);
        res.setFinalScore(finalScore);
        res.setInsights(insights);

        return res;
    }

    private double calculateMonthlyCost(Property property, AnalysisRequest user) {

        double price = property.getCurrentPrice();
        double downPayment = price * user.getDownPaymentPercent();
        double loanAmount = price - downPayment;

        double monthlyRate = user.getInterestRate() / 12;
        int months = 30 * 12;

        double emi = (loanAmount * monthlyRate * Math.pow(1 + monthlyRate, months)) /
                (Math.pow(1 + monthlyRate, months) - 1);

        return emi + property.getMonthlyTax() + property.getHoaFees();
    }

    private int calculateAffordability(double monthlyCost, double income) {

        if (income == 0) return 0;

        double ratio = monthlyCost / income;

        if (ratio <= 0.3) return 100;
        else if (ratio <= 0.5) return 70;
        else if (ratio <= 0.7) return 40;
        else return 10;
    }

    private int calculateTrustScore(Property property, AnalysisRequest user) {

        int score = 100;

        double riskMultiplier = 1 + (1 - user.getRiskTolerance());

        // Flip risk
        if (property.getLastSoldPrice() > 0) {
            double increase = (property.getCurrentPrice() - property.getLastSoldPrice())
                    / property.getLastSoldPrice();

            if (increase > 0.2) {
                score -= (int) (30 * riskMultiplier);
            }
        }

        // Keyword risk
        if (property.getDescription() != null &&
                property.getDescription().toLowerCase().matches(".*(as-is|tlc|fixer).*")) {

            score -= (int) (20 * riskMultiplier);
        }

        return Math.max(score, 0);
    }

    private List<String> generateInsights(Property property, double monthlyCost, AnalysisRequest user) {

        List<String> insights = new ArrayList<>();

        double ratio = monthlyCost / user.getMonthlyIncome();

        if (ratio > 0.5) {
            insights.add("This property is expensive relative to your income.");
        }

        if (property.getLastSoldPrice() > 0) {
            double increase = (property.getCurrentPrice() - property.getLastSoldPrice())
                    / property.getLastSoldPrice();

            if (increase > 0.2) {
                insights.add("Recent price spike suggests possible flipping risk.");
            }
        }

        if (property.getDescription() != null &&
                property.getDescription().toLowerCase().contains("as-is")) {
            insights.add("Listing contains 'as-is', possible structural concerns.");
        }

        return insights;
    }
}