import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year=scan.nextInt();

        //Checking for valid year
        if(year<1582){
            System.out.println("Leap year program only works for years 1582 and later.");
            scan.close();
            return;
        }

        //Checking for leap year
        if(year%400==0){
            System.out.println(year+" is a leap year");
        }
        else if(year%4==0 && year%100!=0){
            System.out.println(year+" is a leap year");
        }
        else{
            System.out.println(year+" is not a leap year");
        }

        scan.close();
    }
}
