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
    public void addCompanyEmpWage(Company company){
        if(company==null){
            throw new IllegalArgumentException("CompanyEmpWage cannot be null.");
        }
        companyEmpWages.add(new CompanyEmpWage(company));
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
    
    private double calculateMonthlyWage(CompanyEmpWage companyEmpWage){

        List<Double> dailyWages = companyEmpWage.getDailyWages();
        dailyWages.clear();

        Company company = companyEmpWage.getCompany();
        
        double monthlyWage = 0.0;
        int numberOfDays = 0;
        double workingHours = 0;
        
        while(numberOfDays < company.getWorkingDaysPerMonth() && workingHours < company.getWorkingHoursPerMonth()){
            double workingHoursPerDay = workingHours(company);
            double dailyWage = workingHoursPerDay * company.getWagePerHour();
            dailyWages.add(dailyWage);
            monthlyWage += dailyWage;
            workingHours+=workingHoursPerDay;
            numberOfDays++;
        }

        return monthlyWage;

    }

    @Override
    public void calculateAllWages(){
        for(CompanyEmpWage companyEmpWage: companyEmpWages){
            double totalWage = calculateMonthlyWage(companyEmpWage);
            companyEmpWage.setTotalWage(totalWage);
        }
    }

    @Override
    public double getTotalWage(Company company){
        CompanyEmpWage found = null;
        for(CompanyEmpWage companyEmpWage: companyEmpWages){
            if(companyEmpWage.getCompany().equals(company)){
                found = companyEmpWage;
                break;
            }
        }
        if(found==null){
            throw new IllegalArgumentException("No such company found in the record.");
        }
        return found.getTotalWage();
    }


}
