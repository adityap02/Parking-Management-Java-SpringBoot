package com.epam.engx.cleancode.comments.task1;

import com.epam.engx.cleancode.comments.task1.thirdpartyjar.InvalidInputException;

public class MortgageInstallmentCalculator {

    /**
     *Calculate Monthly Payment
     * @param principal principal amount
     * @param term term of mortgage in years
     * @param rate rate of interest
     * @return monthly payment amount
     */
    public static double calculateMonthlyPayment(
            int principal, int term, double rate) {

        
        if (principal < 0 || term <= 0 || rate < 0) {
            throw new InvalidInputException("Negative values are not allowed");
        }

        
        rate /= 100.0;

        // convert term from years to months
        double termMonths = term * 12;

        
        if(rate==0)
            return  principal/termMonths;

        double monthlyRate = rate / 12.0;

        double monthlyPayment = (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termMonths));

        return monthlyPayment;
    }
}
