package com.bridgelabz.service;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.model.Company;

public class EmployeeWageBuilder implements EmpWagebuilderInterface{

    private final List<CompanyEmpWage> companyEmpWages;

    public EmployeeWageBuilder() {
        this.companyEmpWages = new ArrayList<>();
    }

    @Override
    public void addCompanyEmpWage(CompanyEmpWage companyEmpWage){
        if(companyEmpWage==null){
            throw new IllegalArgumentException("CompanyEmpWage cannot be null.");
        }
        companyEmpWages.add(companyEmpWage);
    }

    private int checkAttendance(){
        return (int)(Math.random()*3);
    }

    private double workingHours(Company company){
        int attendance = checkAttendance();
        switch (attendance) {
            case 0:
                return  0.0;
            case 1:
                return company.getPartTimeHours();
            case 2:
                return company.getFullTimeHours();
            default:
                throw new IllegalArgumentException("Error while fetching attendance");
        }
    }
    
    private double calculateMonthlyWage(Company company){

        int maximumWorkingDaysPerMonth = company.getWorkingDaysPerMonth();
        double maximumWorkingHoursPerMonth = company.getWorkingHoursPerMonth();
        double wagePerHour = company.getWagePerHour();

        double monthlyWage = 0.0;
        int numberOfDays = 0;
        double workingHours = 0;
        
        while(numberOfDays < maximumWorkingDaysPerMonth  && workingHours < maximumWorkingHoursPerMonth){
            double workingHoursPerDay = workingHours(company);
            monthlyWage += workingHoursPerDay * wagePerHour;
            workingHours+=workingHoursPerDay;
            numberOfDays++;
        }

        return monthlyWage;

    }

    @Override
    public void calculateAllWages(){
        for(CompanyEmpWage companyEmpWage: companyEmpWages){
            double totalWage = calculateMonthlyWage(companyEmpWage.getCompany());
            companyEmpWage.setTotalWage(totalWage);
        }
    }

}
