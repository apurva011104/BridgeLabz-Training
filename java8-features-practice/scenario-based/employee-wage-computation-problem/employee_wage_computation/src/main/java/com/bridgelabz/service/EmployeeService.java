package com.bridgelabz.service;

import com.bridgelabz.model.Employee;

public class EmployeeService{

    private static final double WAGE_PER_HOUR = 20.0;
    private static final double FULL_DAY_HOUR = 8.0;
    private static final double PART_TIME_HOUR = 4.0;
    
    public int checkAttendance(Employee employee){
        return (int)(Math.random()*3);
    }

    public double calculateDailyWage(Employee employee){
        int attendance = checkAttendance(employee);
        double workingHours;

        switch (attendance) {
            case 0:
                workingHours = 0.0;
                break;
            case 1:
                workingHours = PART_TIME_HOUR;
                break;
            case 2:
                workingHours = FULL_DAY_HOUR;
                break;
            default:
                throw new IllegalArgumentException("Error while fetching attendance");
        }

        return WAGE_PER_HOUR * workingHours;

    }
}