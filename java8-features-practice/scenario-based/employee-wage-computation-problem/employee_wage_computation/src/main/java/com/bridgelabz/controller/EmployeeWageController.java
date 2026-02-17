package com.bridgelabz.controller;

import com.bridgelabz.model.Company;
import com.bridgelabz.service.EmpWagebuilderInterface;

public class EmployeeWageController {
    
    private final EmpWagebuilderInterface wageBuilder;

    public EmployeeWageController(EmpWagebuilderInterface wageBuilder) {
        this.wageBuilder = wageBuilder;
    }

    public void addCompany(Company company) {
        wageBuilder.addCompanyEmpWage(company);
    }

    public void computeWages() {
        wageBuilder.calculateAllWages();
    }

    public double getTotalWage(Company company){
        return wageBuilder.getTotalWage(company);
    }
}
