package com.bridgelabz.model;

public class Company {
    
    private String companyName;
    private double wagePerHour;
    private double fullTimeHours;
    private double partTimeHours;
    private int workingDaysPerMonth;
    private double workingHoursPerMonth;

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

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getWagePerHour() {
        return wagePerHour;
    }

    public void setWagePerHour(double wagePerHour) {
        this.wagePerHour = wagePerHour;
    }

    public double getFullTimeHours() {
        return fullTimeHours;
    }

    public void setFullTimeHours(double fullTimeHours) {
        this.fullTimeHours = fullTimeHours;
    }

    public double getPartTimeHours() {
        return partTimeHours;
    }

    public void setPartTimeHours(double partTimeHours) {
        this.partTimeHours = partTimeHours;
    }

    public int getWorkingDaysPerMonth() {
        return workingDaysPerMonth;
    }

    public void setWorkingDaysPerMonth(int workingDaysPerMonth) {
        this.workingDaysPerMonth = workingDaysPerMonth;
    }

    public double getWorkingHoursPerMonth() {
        return workingHoursPerMonth;
    }

    public void setWorkingHoursPerMonth(double workingHoursPerMonth) {
        this.workingHoursPerMonth = workingHoursPerMonth;
    }

}
