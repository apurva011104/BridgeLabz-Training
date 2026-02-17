package com.bridgelabz.controller;

import com.bridgelabz.service.CompanyEmpWage;
import com.bridgelabz.service.EmpWagebuilderInterface;

public class EmployeeWageController {
    
    private final EmpWagebuilderInterface wageBuilder;

    public EmployeeWageController(EmpWagebuilderInterface wageBuilder) {
        this.wageBuilder = wageBuilder;
    }

    public void addCompany(CompanyEmpWage companyEmpWage) {
        wageBuilder.addCompanyEmpWage(companyEmpWage);
    }

    public void computeWages() {
        wageBuilder.calculateAllWages();
    }
}
