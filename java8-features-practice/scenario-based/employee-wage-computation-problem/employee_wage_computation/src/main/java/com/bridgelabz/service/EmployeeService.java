package com.bridgelabz.service;

import com.bridgelabz.model.Employee;

public class EmployeeService{

    private static double WAGE_PER_HOUR = 20.0;
    private static double FULL_DAY_HOUR = 8.0;
    
    public boolean checkAttendance(Employee employee){
        int attendance = (int)(Math.random()*2);
        if(attendance==0){
            return false;
        }
        else{
            return true;
        }
    }

    public double calculateDailyWage(Employee employee){
        boolean isPresent = checkAttendance(employee);
        return isPresent ? (WAGE_PER_HOUR * FULL_DAY_HOUR) : 0.0;

    }
}