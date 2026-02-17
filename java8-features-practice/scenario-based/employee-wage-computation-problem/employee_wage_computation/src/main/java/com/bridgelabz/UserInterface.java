package com.bridgelabz;

import com.bridgelabz.model.Company;
import com.bridgelabz.service.EmployeeWageBuilder;

public class UserInterface{
    public static void main(String [] args){
        System.out.println("Welcome to employee wage computation program");

        Company company1 = new Company("Company1", 20, 8, 4, 20, 100);
        Company company2 = new Company("Company2", 30, 9, 4, 22, 120);


        EmployeeWageBuilder employeeWageBuilder = new EmployeeWageBuilder();

        double monthlyWage1 = employeeWageBuilder.calculateMonthlyWage(company1);
        double monthlyWage2 = employeeWageBuilder.calculateMonthlyWage(company2);

        System.out.printf("Monthly wage of Company1: %.2f INR%n", monthlyWage1);
        System.out.printf("Monthly wage of Company2: %.2f INR%n", monthlyWage2);
    }
}