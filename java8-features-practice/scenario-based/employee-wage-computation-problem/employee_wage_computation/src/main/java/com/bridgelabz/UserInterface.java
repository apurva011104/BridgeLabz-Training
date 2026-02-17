package com.bridgelabz;

import com.bridgelabz.controller.EmployeeWageController;
import com.bridgelabz.model.Company;
import com.bridgelabz.service.CompanyEmpWage;
import com.bridgelabz.service.EmpWagebuilderInterface;
import com.bridgelabz.service.EmployeeWageBuilder;

public class UserInterface{
    public static void main(String [] args){
        System.out.println("Welcome to employee wage computation program");

        Company company1 = new Company("Company1", 20, 8, 4, 20, 100);
        Company company2 = new Company("Company2", 30, 9, 4, 22, 120);

        CompanyEmpWage companyEmpWage1 = new CompanyEmpWage(company1);
        CompanyEmpWage companyEmpWage2 = new CompanyEmpWage(company2);

        EmpWagebuilderInterface empWagebuilder = new EmployeeWageBuilder();
        EmployeeWageController controller = new EmployeeWageController(empWagebuilder);

        controller.addCompany(companyEmpWage1);
        controller.addCompany(companyEmpWage2);

        controller.computeWages();

        System.out.printf("Monthly wage of Company1: %.2f INR%n", companyEmpWage1.getTotalWage());
        System.out.printf("Monthly wage of Company2: %.2f INR%n", companyEmpWage2.getTotalWage());
    }
}