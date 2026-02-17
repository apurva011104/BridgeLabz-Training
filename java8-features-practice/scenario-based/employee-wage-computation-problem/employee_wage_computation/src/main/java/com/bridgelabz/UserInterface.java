package com.bridgelabz;

import com.bridgelabz.model.Company;
import com.bridgelabz.service.EmployeeWageBuilder;

public class UserInterface{
    public static void main(String [] args){
        System.out.println("Welcome to employee wage computation program");

        Company company1 = new Company("Company1", 20, 8, 4, 20, 100);
        Company company2 = new Company("Company2", 30, 9, 4, 22, 120);


        EmployeeWageBuilder employeeWageBuilder1 = new EmployeeWageBuilder(company1);
        EmployeeWageBuilder employeeWageBuilder2 = new EmployeeWageBuilder(company2);

        System.out.printf("Monthly wage of Company1: %.2f INR%n", employeeWageBuilder1.getTotalWage());
        System.out.printf("Monthly wage of Company2: %.2f INR%n", employeeWageBuilder2.getTotalWage());
    }
}