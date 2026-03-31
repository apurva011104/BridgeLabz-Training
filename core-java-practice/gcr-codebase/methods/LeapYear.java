import java.util.Scanner;

public class LeapYear {

    public static boolean isLeapYear(int year){
        return (year>1582) && ((year%400==0) || (year%4==0 && year%100!=0));
    }
    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year=scan.nextInt();
        while(year<=0){
            System.out.print("Year should be greater than 0. Enter again: ");
            year=scan.nextInt();
        }
        
        boolean isLeapYear=isLeapYear(year);
        System.out.println("Is the year "+year+" leap year? "+isLeapYear);
        scan.close();
    }
}
