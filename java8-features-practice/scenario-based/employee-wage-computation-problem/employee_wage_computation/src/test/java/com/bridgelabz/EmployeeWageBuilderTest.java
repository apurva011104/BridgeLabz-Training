package com.bridgelabz;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bridgelabz.model.Company;
import com.bridgelabz.service.EmployeeWageBuilder;

public class EmployeeWageBuilderTest {
    EmployeeWageBuilder employeeWageBuilder;
    Company company;

    @BeforeEach
    public void initializeCompanyVariable(){
        this.company = new Company("Company1" , 20, 8, 4, 20, 100);
        employeeWageBuilder = new EmployeeWageBuilder(company);
    }

    @Test
    public void testCalculateMonthlyWage(){
        double monthlyWage = employeeWageBuilder.getTotalWage();
        double maximumWage = company.getWagePerHour() * company.getFullTimeHours() * company.getWorkingDaysPerMonth();

        assertTrue(maximumWage>=monthlyWage);
    }
}
