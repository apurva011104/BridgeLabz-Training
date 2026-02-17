package com.bridgelabz.service;

import com.bridgelabz.model.Company;

public class CompanyEmpWage {
    
    private final Company company;
    private double totalWage;

    public CompanyEmpWage(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public double getTotalWage() {
        return totalWage;
    }

    public void setTotalWage(double totalWage) {
        this.totalWage = totalWage;
    }


    
}
