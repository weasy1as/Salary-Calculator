package com.example.salarycalculator.service;

import com.example.salarycalculator.model.SalaryInput;
import com.example.salarycalculator.model.SalaryResult;
import org.springframework.stereotype.Service;

@Service
public class SalaryCalculatorService {

    private static final double PENSION_PERCENT = 0.018; // 1.8%
    private static final double AM_BIDRAG_PERCENT = 0.08; // 8%
    private static final double TAX_PERCENT = 0.38;       // 38%
    private static final double FRADRAG = 4230.0;         // DKK
    private static final double UNION_FEE = 30.0;         // DKK

    public SalaryResult calculate(SalaryInput input) {
        double B = input.getHourlyRate() * input.getHoursWorked(); // Gross salary

        // 1. Egen pension
        double egenPension = B * PENSION_PERCENT;

        // 2. AM-bidrag
        double amBidrag = (B - egenPension) * AM_BIDRAG_PERCENT;

        // 3. A-skat (taxable income minus fradrag)
        double taxableIncome = B - egenPension - amBidrag - FRADRAG;
        double aSkat = taxableIncome > 0 ? taxableIncome * TAX_PERCENT : 0;

        // 4. Net salary
        double netto = B - egenPension - amBidrag - aSkat - UNION_FEE;

        return new SalaryResult(netto, amBidrag, aSkat, egenPension, UNION_FEE, 0);
    }
}
