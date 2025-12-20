import java.util.Scanner;

public class DayOfTheWeek {

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static void main(String[] args) {
        
        Scanner scan=new Scanner(System.in);

        //Taking input for date
        System.out.print("Enter a year: ");
        int year=scan.nextInt();
        System.out.print("Enter a month (1-12): ");
        int month=scan.nextInt();
        System.out.print("Enter a day (1-31): ");
        int day=scan.nextInt();

        //Checking for valid date
        if(month<1 || month>12 || day<1 || day>31) {
            System.out.println("Invalid month or day input.");
        }
        else if(month==2){
            if(day>29){
                System.out.println("Invalid day for February");
            } 
            else if(day==29 && !isLeapYear(year)){
                System.out.println("Invalid day for February in a non-leap year.");
            }
        }
        else if(month==4 || month==6 || month==9 || month==11) {
            if(day>30){
                System.out.println("Invalid day for the given month.");
            }
        }
        else{

            //Calculating day of the week
            int y0= year - (14 - month) / 12;
            int x = y0 + y0/4 - y0/100 + y0/400;
            int m0 = month + 12 * ((14 - month) / 12) - 2;
            int d0 = (day + x + (31*m0)/12) % 7;

            String dayOfWeek="";

            switch(d0){
                case 0:
                    dayOfWeek="Sunday";
                    break;
                case 1:
                    dayOfWeek="Monday";
                    break;
                case 2:
                    dayOfWeek="Tuesday";
                    break;
                case 3:
                    dayOfWeek="Wednesday";
                    break;
                case 4:
                    dayOfWeek="Thursday";
                    break;
                case 5:
                    dayOfWeek="Friday";
                    break;
                case 6:
                    dayOfWeek="Saturday";
                    break;
            }
            System.out.println("The day of the week is: "+dayOfWeek);
        
        }

        scan.close();
    }
}
