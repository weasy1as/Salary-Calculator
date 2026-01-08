package com.example.salarycalculator.model;

public class SalaryResult {

    private double netSalary;
    private double amBidrag;
    private double tax;
    private double pension;
    private double unionFee;
    private double otherDeductions;


    public SalaryResult(double netSalary, double amBidrag, double tax, double pension, double unionFee, double otherDeductions) {
        this.netSalary = netSalary;
        this.amBidrag = amBidrag;
        this.tax = tax;
        this.pension = pension;
        this.unionFee = unionFee;
        this.otherDeductions = otherDeductions;
    }

    public double getNetSalary() { return netSalary; }
    public double getAmBidrag() { return amBidrag; }
    public double getTax() { return tax; }
    public double getPension() { return pension; }
    public double getUnionFee() { return unionFee; }
    public double getOtherDeductions() { return otherDeductions; }
}
