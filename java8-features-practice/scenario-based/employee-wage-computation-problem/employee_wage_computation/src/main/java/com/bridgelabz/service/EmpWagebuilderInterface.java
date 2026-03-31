package com.bridgelabz.service;

import com.bridgelabz.model.Company;

public interface EmpWagebuilderInterface {
    
    void addCompanyEmpWage(Company company);

    void calculateAllWages();

    double getTotalWage(Company company);

}
