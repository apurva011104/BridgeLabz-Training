import java.util.Scanner;

public class Calendar {

    public static  boolean  isLeapYear(int year){
        return (year%4==0 && year%100!=0) || (year%400==0);
    }

    public static int dayofWeek(int date,int month, int year){
        int y0= year - (14 - month) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (date + x + (31*m0)/12) % 7;

        return d0;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a month(1-12): ");
        int month=scan.nextInt();
        while(month<1 || month>12){
            System.out.print("Invalid month! Enter again: ");
            month=scan.nextInt();
        }
        System.out.print("Enter a year(>=1582): ");
        int year=scan.nextInt();
        while(year<1582){
            System.out.print("Invalid year! Enter again: ");
            year=scan.nextInt();
        }
        int dayofWeek=dayofWeek(1, month, year);
        boolean isLeapYear = isLeapYear(year);
        int numberOfDays;
        if(month==4 || month==6 || month==9 || month==11){
            numberOfDays=30;
        }
        else if(month==2){
            numberOfDays=isLeapYear?29:28;
        }
        else{
            numberOfDays=31;
        }
        int date=1;
        int col=0;
        int row=1;
        System.out.println(month+", "+year);
        System.out.println("Sun     Mon     Tue     Wed     Thur    Fri     Sat");
        while(date<numberOfDays){
            if(row==1 && col<dayofWeek){
                System.out.print("\t");
                col++;
            }
            else if(col<7){
                System.out.print(((date<10)?"0":"")+date+"  \t");
                col++;
                date++;
            }
            else{
                System.out.println();
                row++;
                col=0;
            }
        }
    }    
}
