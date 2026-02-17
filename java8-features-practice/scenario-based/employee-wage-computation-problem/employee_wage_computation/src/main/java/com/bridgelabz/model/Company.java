package com.bridgelabz.model;

public class Company {
    
    private final String companyName;
    private final double wagePerHour;
    private final double fullTimeHours;
    private final double partTimeHours;
    private final int workingDaysPerMonth;
    private final double workingHoursPerMonth;

    public Company(String companyName, double wagePerHour, double fullTimeHours, double partTimeHours, int workingDaysPerMonth, double workingHoursPerMonth) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.fullTimeHours = fullTimeHours;
        this.partTimeHours = partTimeHours;
        this.workingDaysPerMonth = workingDaysPerMonth;
        this.workingHoursPerMonth = workingHoursPerMonth;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getWagePerHour() {
        return wagePerHour;
    }

    public double getFullTimeHours() {
        return fullTimeHours;
    }

    public double getPartTimeHours() {
        return partTimeHours;
    }

    public int getWorkingDaysPerMonth() {
        return workingDaysPerMonth;
    }

    public double getWorkingHoursPerMonth() {
        return workingHoursPerMonth;
    }



}
