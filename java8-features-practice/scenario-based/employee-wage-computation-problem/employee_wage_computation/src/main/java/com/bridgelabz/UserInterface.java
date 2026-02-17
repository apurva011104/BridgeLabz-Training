package com.bridgelabz;

import com.bridgelabz.controller.EmployeeWageController;
import com.bridgelabz.model.Company;
import com.bridgelabz.service.EmpWagebuilderInterface;
import com.bridgelabz.service.EmployeeWageBuilder;

public class UserInterface{
    public static void main(String [] args){
        System.out.println("Welcome to employee wage computation program");

        Company company1 = new Company("Company1", 20, 8, 4, 20, 100);
        Company company2 = new Company("Company2", 30, 9, 4, 22, 120);

        EmpWagebuilderInterface empWagebuilder = new EmployeeWageBuilder();
        EmployeeWageController controller = new EmployeeWageController(empWagebuilder);

        controller.addCompany(company1);
        controller.addCompany(company2);

        controller.computeWages();

        System.out.printf("Monthly wage of Company1: %.2f INR%n", controller.getTotalWage(company1));
        System.out.printf("Monthly wage of Company2: %.2f INR%n", controller.getTotalWage(company2));
    }
}