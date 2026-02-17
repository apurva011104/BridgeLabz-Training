package com.bridgelabz.service;

import com.bridgelabz.model.Company;

public class EmployeeWageBuilder implements EmpWagebuilderInterface{

    private CompanyEmpWage[] companyEmpWages;
    private int size=0;

    public EmployeeWageBuilder() {
        this.companyEmpWages = new CompanyEmpWage[5];
    }

    @Override
    public void addCompanyEmpWage(CompanyEmpWage companyEmpWage){
        if(companyEmpWage==null){
            throw new IllegalArgumentException("CompanyEmpWage cannot be null.");
        }
        if(size==companyEmpWages.length){
            resize();
        }
        companyEmpWages[size] = companyEmpWage;
        size++;
    }

    private void resize(){
        CompanyEmpWage[] newCompanyEmpWages = new CompanyEmpWage[2 * this.companyEmpWages.length];
        for(int i=0 ; i<companyEmpWages.length ; i++){
            newCompanyEmpWages[i] = this.companyEmpWages[i];
        }
        this.companyEmpWages = newCompanyEmpWages;
    }


    public int checkAttendance(){
        return (int)(Math.random()*3);
    }

    private double workingHours(Company company){
        int attendance = checkAttendance();
        switch (attendance) {
            case 0:
                return  0.0;
            case 1:
                return company.getPartTimeHours();
            case 2:
                return company.getFullTimeHours();
            default:
                throw new IllegalArgumentException("Error while fetching attendance");
        }
    }
    
    private double calculateMonthlyWage(Company company){

        int maximumWorkingDaysPerMonth = company.getWorkingDaysPerMonth();
        double maximumWorkingHoursPerMonth = company.getWorkingHoursPerMonth();
        double wagePerHour = company.getWagePerHour();

        double monthlyWage = 0.0;
        int numberOfDays = 0;
        double workingHours = 0;
        
        while(numberOfDays < maximumWorkingDaysPerMonth  && workingHours < maximumWorkingHoursPerMonth){
            double workingHoursPerDay = workingHours(company);
            monthlyWage += workingHoursPerDay * wagePerHour;
            workingHours+=workingHoursPerDay;
            numberOfDays++;
        }

        return monthlyWage;

    }

    @Override
    public void calculateAllWages(){
        for(int i=0; i<size ; i++){
            CompanyEmpWage companyEmpWage = companyEmpWages[i];

            double totalWage = calculateMonthlyWage(companyEmpWage.getCompany());

            companyEmpWage.setTotalWage(totalWage);
        }
    }

}
