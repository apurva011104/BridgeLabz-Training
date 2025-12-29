public class EmployeeWageComputation {

    static final int WAGE_PER_HOUR = 20;
    static final int FULL_DAY_HOUR = 8;
    static final int PART_TIME_HOUR = 4;
    static final int MAXIMUM_WORKING_DAYS_PER_MONTH = 20;
    static final int MAXIMUM_WORKING_HOURS_PER_MONTH = 100;

    //Start: Method to display welcome
    public static void start(){
        System.out.println("Welcome to Employee Wage Computation program");
    }

    //UC1: Check if employee is present or absent
    public static int presentOrAbsent(){
        return (Math.random()<0.5)?0:1;     //Returns 1 if present else 0
    }

    //Method to get working hours for the day
    public static int getWorkingHours(){
       int fullTime = (int)(Math.random()*2);

       //UC4: Use of switch case statement
        switch(fullTime){
            case 1:
                return FULL_DAY_HOUR;
            case 0:
                return PART_TIME_HOUR;
            default:
                return 0;
        }  
    }

    //UC2: Method to calculate daily employee wage
    public static int calculateDailyWage(int workingHours){
        return workingHours * WAGE_PER_HOUR;
    }

    public static void main(String[] args) {

        start();

        int totalWorkingDays = 0;
        int totalWorkingHours = 0;
        int totalWage = 0;

        //UC6: Calculate wages till a condition of total working hours or days is reached for a month
        while(totalWorkingDays < MAXIMUM_WORKING_DAYS_PER_MONTH && totalWorkingHours < MAXIMUM_WORKING_HOURS_PER_MONTH){
            totalWorkingDays++;

            int presentOrAbsent = presentOrAbsent();

            int workingHoursForADay;

            //UC4: Use of switch case statement
            switch(presentOrAbsent){
                case 1:
                    workingHoursForADay=getWorkingHours();
                    break;
                case 0:
                    workingHoursForADay=0;
                    break;
                default:
                    workingHoursForADay=0;
            }

            totalWorkingHours+=workingHoursForADay;

            int dailyWage = calculateDailyWage(workingHoursForADay);
            totalWage+=dailyWage;       //UC5: Calculating wages daily for a month

            System.out.println("Day "+(totalWorkingDays));
            System.out.println("Present or Absent: "+(presentOrAbsent==0?"Absent":"Present"));
            System.out.println("Today's work hours: "+workingHoursForADay);
            System.out.println("Today's wage: "+dailyWage);
            System.out.println("---------------------------------------------------");
        }

        System.out.println("Monthly data");
        System.out.println("Total working days: "+totalWorkingDays);
        System.out.println("Total working hours: "+totalWorkingHours);
        System.out.println("Total wage: "+totalWage);

    }
}
