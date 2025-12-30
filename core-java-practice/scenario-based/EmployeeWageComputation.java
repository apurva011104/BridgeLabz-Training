public class EmployeeWageComputation {

    //Initializing constants
    static final int IS_FULL_TIME = 2;
    static final int IS_PART_TIME = 1;
    static final int WAGE_PER_HOUR = 20;
    static final int FULL_DAY_HOUR = 8;
    static final int PART_TIME_HOUR = 4;
    static final int MAXIMUM_WORKING_DAYS_PER_MONTH = 20;
    static final int MAXIMUM_WORKING_HOURS_PER_MONTH = 100;

    //Method to display welcome
    public static void start(){
        System.out.println("Welcome to Employee Wage Computation program");
    }

    //Method to check if employee is full time, part time or absent
    public static int checkEmployee(){
        return (int)(Math.random()*3);
    }

    //Method to get employee status
    public static String employeeStatus(int checkEmployee){
        switch(checkEmployee){
            case IS_FULL_TIME:
                return "Full Time Employee";
            case IS_PART_TIME:
                return "Part Time Employee";
            default:
                return "Absent";
        }  
    }

    //Method to get working hours for the day
    public static int getWorkingHours( int checkEmployee ){
        switch(checkEmployee){
            case IS_FULL_TIME:
                return FULL_DAY_HOUR;
            case IS_PART_TIME:
                return PART_TIME_HOUR;
            default:
                return 0;
        }  
    }


    //Method to calculate daily employee wage
    public static int calculateDailyWage(int workingHours){
        return workingHours * WAGE_PER_HOUR;
    }

    public static void main(String[] args) {

        start();

        int totalWorkingDays = 0;
        int totalWorkingHours = 0;
        int totalWage = 0;

        //Calculate wages till a condition of total working hours or days is reached for a month
        while(totalWorkingDays < MAXIMUM_WORKING_DAYS_PER_MONTH && totalWorkingHours < MAXIMUM_WORKING_HOURS_PER_MONTH){
            totalWorkingDays++;

            int checkEmployee = checkEmployee();
            String employeeStatus = employeeStatus(checkEmployee);
            int workingHoursForADay = getWorkingHours(checkEmployee);

            totalWorkingHours+=workingHoursForADay;

            int dailyWage = calculateDailyWage(workingHoursForADay);
            totalWage+=dailyWage;       //Calculating wages daily for a month

            //Displaying daily data
            System.out.println("Day "+(totalWorkingDays));
            System.out.println("Employee status "+employeeStatus);
            System.out.println("Today's work hours: "+workingHoursForADay);
            System.out.println("Today's wage: "+dailyWage);
            System.out.println("---------------------------------------------------");
        }

        //Displaying monthly data
        System.out.println("Monthly data");
        System.out.println("Total working days: "+totalWorkingDays);
        System.out.println("Total working hours: "+totalWorkingHours);
        System.out.println("Total wage: "+totalWage);

    }
}
