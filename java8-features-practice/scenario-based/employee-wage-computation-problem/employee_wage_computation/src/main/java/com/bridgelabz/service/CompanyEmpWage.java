package com.bridgelabz.service;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.model.Company;

public class CompanyEmpWage {
    
    private final Company company;
    private final List<Double> dailyWages;
    private double totalWage;

    public CompanyEmpWage(Company company) {
        this.company = company;
        this.dailyWages = new ArrayList<>();
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

    public List<Double> getDailyWages() {
        return dailyWages;
    }


    
}
