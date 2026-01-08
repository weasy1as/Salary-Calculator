package com.example.salarycalculator.controller;

import com.example.salarycalculator.model.SalaryInput;
import com.example.salarycalculator.model.SalaryResult;
import com.example.salarycalculator.service.SalaryCalculatorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/salary")
@CrossOrigin(origins = "http://localhost:3000")
public class SalaryController {

    private final SalaryCalculatorService service;

    public SalaryController(SalaryCalculatorService service) {
        this.service = service;
    }

    @PostMapping("/calculate")
    public ResponseEntity<SalaryResult> calculateSalary(@Valid @RequestBody SalaryInput input) {
        SalaryResult result = service.calculate(input);
        return ResponseEntity.ok(result);
    }
}
