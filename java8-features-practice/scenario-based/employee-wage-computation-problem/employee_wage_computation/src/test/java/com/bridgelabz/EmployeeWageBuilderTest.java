package com.bridgelabz;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bridgelabz.model.Company;
import com.bridgelabz.service.CompanyEmpWage;
import com.bridgelabz.service.EmployeeWageBuilder;

public class EmployeeWageBuilderTest {
    EmployeeWageBuilder employeeWageBuilder;
    CompanyEmpWage companyEmpWage;
    Company company;

    @BeforeEach
    public void initialize(){
        this.company = new Company("Company1" , 20, 8, 4, 20, 100);
        this.companyEmpWage = new CompanyEmpWage(company);
        employeeWageBuilder = new EmployeeWageBuilder();
        employeeWageBuilder.addCompanyEmpWage(companyEmpWage);
    }

    @Test
    public void testCalculateMonthlyWage(){
        employeeWageBuilder.calculateAllWages();
        double monthlyWage = companyEmpWage.getTotalWage();
        double maximumWage = company.getWagePerHour() * company.getFullTimeHours() * company.getWorkingDaysPerMonth();

        assertTrue(maximumWage>=monthlyWage);
    }
}
