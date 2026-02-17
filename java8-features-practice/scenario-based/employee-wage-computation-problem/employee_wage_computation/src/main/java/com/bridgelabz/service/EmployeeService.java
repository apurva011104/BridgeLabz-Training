package com.bridgelabz.service;

import com.bridgelabz.model.Employee;

public class EmployeeService{
    public boolean checkAttendance(Employee employee){
        int attendance = (int)(Math.random()*2);
        if(attendance==0){
            return false;
        }
        else{
            return true;
        }
        
    }
}