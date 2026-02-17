package com.bridgelabz.service;

import com.bridgelabz.model.Employee;

public class EmployeeService{

    private static final double WAGE_PER_HOUR = 20.0;
    private static final double FULL_DAY_HOUR = 8.0;
    private static final double PART_TIME_HOUR = 4.0;
    private static final int WORKING_DAYS_PER_MONTH = 20;
    private static final double WORKING_HOURS_PER_MONTH = 100;
    
    public int checkAttendance(){
        return (int)(Math.random()*3);
    }

    private double workingHours(){
        int attendance = checkAttendance();
        switch (attendance) {
            case 0:
                return  0.0;
            case 1:
                return  PART_TIME_HOUR;
            case 2:
                return FULL_DAY_HOUR;
            default:
                throw new IllegalArgumentException("Error while fetching attendance");
        }
    }
    
    public double calculateMonthlyWage(Employee employee){
        double monthlyWage = 0.0;
        int numberOfDays = 0;
        double workingHours = 0;
        
        while(numberOfDays < WORKING_DAYS_PER_MONTH && workingHours < WORKING_HOURS_PER_MONTH){
            double workingHoursPerDay = workingHours();
            monthlyWage += workingHoursPerDay * WAGE_PER_HOUR;
            workingHours+=workingHoursPerDay;
            numberOfDays++;
        }

        return monthlyWage;

    }
}