package com.example.salarycalculator.service;

import com.example.salarycalculator.model.SalaryInput;
import com.example.salarycalculator.model.SalaryResult;
import org.springframework.stereotype.Service;

@Service
public class SalaryCalculatorService {

    private static final double AM_BIDRAG_PERCENT = 0.08; // 8%
    private static final double TAX_PERCENT = 0.38;       // 38%
    private static final double UNION_FEE = 30.0;         // DKK

    public SalaryResult calculate(SalaryInput input) {
        double grossSalary = input.getHourlyRate() * input.getHoursWorked();

        double amBidrag = grossSalary * AM_BIDRAG_PERCENT;
        double salaryAfterAmBidrag = grossSalary - amBidrag;

        double pension = 0;
        if (input.getPensionPercentage() != null) {
            pension = salaryAfterAmBidrag * (input.getPensionPercentage() / 100);
        }

        double tax = (salaryAfterAmBidrag - pension) * TAX_PERCENT;

        double otherDeductions = input.getOtherDeductions() != null ? input.getOtherDeductions() : 0;

        double netSalary = salaryAfterAmBidrag - pension - tax - UNION_FEE - otherDeductions;

        return new SalaryResult(netSalary, amBidrag, tax, pension, UNION_FEE, otherDeductions);
    }
}
