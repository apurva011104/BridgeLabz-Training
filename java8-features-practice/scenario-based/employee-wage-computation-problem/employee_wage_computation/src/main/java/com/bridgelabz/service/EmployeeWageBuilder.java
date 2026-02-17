package com.bridgelabz.service;

public class EmployeeWageBuilder {

    private double wagePerHour;
    private double fullDayHour;
    private double partTimeHour;
    private int maximumWorkingDaysPerMonth;
    private double maximumWorkingHoursPerMonth;

    public EmployeeWageBuilder(double wagePerHour, double fullDayHour, double partTimeHour, int maximumWorkingDaysPerMonth, double maximumWorkingHoursPerMonth) {
        this.wagePerHour = wagePerHour;
        this.fullDayHour = fullDayHour;
        this.partTimeHour = partTimeHour;
        this.maximumWorkingDaysPerMonth = maximumWorkingDaysPerMonth;
        this.maximumWorkingHoursPerMonth = maximumWorkingHoursPerMonth;
    }

    public double getWagePerHour() {
        return wagePerHour;
    }

    public void setWagePerHour(double wagePerHour) {
        this.wagePerHour = wagePerHour;
    }

    public double getFullDayHour() {
        return fullDayHour;
    }

    public void setFullDayHour(double fullDayHour) {
        this.fullDayHour = fullDayHour;
    }

    public double getPartTimeHour() {
        return partTimeHour;
    }

    public void setPartTimeHour(double partTimeHour) {
        this.partTimeHour = partTimeHour;
    }

    public int getMaximumWorkingDaysPerMonth() {
        return maximumWorkingDaysPerMonth;
    }

    public void setMaximumWorkingDaysPerMonth(int maximumWorkingDaysPerMonth) {
        this.maximumWorkingDaysPerMonth = maximumWorkingDaysPerMonth;
    }

    public double getMaximumWorkingHoursPerMonth() {
        return maximumWorkingHoursPerMonth;
    }

    public void setMaximumWorkingHoursPerMonth(double maximumWorkingHoursPerMonth) {
        this.maximumWorkingHoursPerMonth = maximumWorkingHoursPerMonth;
    }

     public int checkAttendance(){
        return (int)(Math.random()*3);
    }

    private double workingHours(){
        int attendance = checkAttendance();
        switch (attendance) {
            case 0:
                return  0.0;
            case 1:
                return  partTimeHour;
            case 2:
                return fullDayHour;
            default:
                throw new IllegalArgumentException("Error while fetching attendance");
        }
    }
    
    public double calculateMonthlyWage(){
        double monthlyWage = 0.0;
        int numberOfDays = 0;
        double workingHours = 0;
        
        while(numberOfDays < maximumWorkingDaysPerMonth && workingHours < maximumWorkingHoursPerMonth){
            double workingHoursPerDay = workingHours();
            monthlyWage += workingHoursPerDay * wagePerHour;
            workingHours+=workingHoursPerDay;
            numberOfDays++;
        }

        return monthlyWage;

    }

}
