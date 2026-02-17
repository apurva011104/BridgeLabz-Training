package com.bridgelabz.service;

import com.bridgelabz.model.Company;

public class EmployeeWageBuilder {

    private final Company company;
    private double totalWage;

    public EmployeeWageBuilder(Company company) {
        this.company = company;
        this.totalWage = calculateMonthlyWage();
    }

    public double getTotalWage() {
        return totalWage;
    }

    public int checkAttendance(){
        return (int)(Math.random()*3);
    }

    private double workingHours(){
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
    
    private double calculateMonthlyWage(){

        int maximumWorkingDaysPerMonth = company.getWorkingDaysPerMonth();
        double maximumWorkingHoursPerMonth = company.getWorkingHoursPerMonth();
        double wagePerHour = company.getWagePerHour();

        double monthlyWage = 0.0;
        int numberOfDays = 0;
        double workingHours = 0;
        
        while(numberOfDays < maximumWorkingDaysPerMonth  && workingHours < maximumWorkingHoursPerMonth){
            double workingHoursPerDay = workingHours();
            monthlyWage += workingHoursPerDay * wagePerHour;
            workingHours+=workingHoursPerDay;
            numberOfDays++;
        }

        return monthlyWage;

    }

}
