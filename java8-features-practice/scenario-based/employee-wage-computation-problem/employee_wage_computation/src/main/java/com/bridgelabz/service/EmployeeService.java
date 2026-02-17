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
        double workingHours = attendance==0 ? 0.0 : (attendance==1 ? PART_TIME_HOUR : FULL_DAY_HOUR );
        return WAGE_PER_HOUR * workingHours;

    }
}