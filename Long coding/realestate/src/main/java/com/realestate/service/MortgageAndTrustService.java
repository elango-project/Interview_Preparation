package com.realestate.service;

import com.realestate.model.Property;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class MortgageAndTrustService {

    private static final double INTEREST_RATE = 0.065;
    private static final int LOAN_TERM_YEARS = 30;
    private static final double DOWN_PAYMENT_PERCENT = 0.20;

    public Map<String, Object> analyzeProperty(Property property) {
        Map<String, Object> analysis = new HashMap<>();

        double principal = property.getCurrentPrice() * (1 - DOWN_PAYMENT_PERCENT);
        double monthlyRate = INTEREST_RATE / 12;
        int totalPayments = LOAN_TERM_YEARS * 12;

        double mathTop = monthlyRate * Math.pow(1 + monthlyRate, totalPayments);
        double mathBottom = Math.pow(1 + monthlyRate, totalPayments) - 1;
        double baseMortgage = principal * (mathTop / mathBottom);

        double monthlyTax = property.getAnnualPropertyTax() / 12;
        double trueMonthlyCost = baseMortgage + monthlyTax + property.getMonthlyHoaFee();

        analysis.put("baseMortgage", Math.round(baseMortgage));
        analysis.put("trueMonthlyCost", Math.round(trueMonthlyCost));

        int trustScore = 100;
        String riskWarning = "None";

        if (property.getMonthsSinceLastSale() <= 12) {
            double priceIncrease = (property.getCurrentPrice() - property.getLastSoldPrice()) / property.getLastSoldPrice();
            if (priceIncrease > 0.20) {
                trustScore -= 30;
                riskWarning = "High Risk: Price increased " + Math.round(priceIncrease * 100) + "% in " + property.getMonthsSinceLastSale() + " months. Potential flip.";
            }
        }

        if (property.getRedFlagKeywords() != null && !property.getRedFlagKeywords().isEmpty()) {
            trustScore -= 20;
            if (riskWarning.equals("None")) riskWarning = "";
            riskWarning += " Warning: Risky keywords detected (" + property.getRedFlagKeywords() + ").";
        }

        analysis.put("trustScore", trustScore);
        analysis.put("riskWarning", riskWarning);

        return analysis;
    }
}