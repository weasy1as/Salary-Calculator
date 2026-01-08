package com.example.salarycalculator.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class SalaryInput {

    @NotNull(message = "Hourly rate is required")
    @Min(value = 0, message = "Hourly rate must be positive")
    private Double hourlyRate;

    @NotNull(message = "Hours worked is required")
    @Min(value = 0, message = "Hours worked must be positive")
    private Double hoursWorked;

    @Min(value = 0, message = "Pension must be non-negative")
    private Double pensionPercentage; // Optional

    private Double otherDeductions; // Optional fixed deductions


    public Double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(Double hourlyRate) { this.hourlyRate = hourlyRate; }
    public Double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(Double hoursWorked) { this.hoursWorked = hoursWorked; }
    public Double getPensionPercentage() { return pensionPercentage; }
    public void setPensionPercentage(Double pensionPercentage) { this.pensionPercentage = pensionPercentage; }
    public Double getOtherDeductions() { return otherDeductions; }
    public void setOtherDeductions(Double otherDeductions) { this.otherDeductions = otherDeductions; }
}
