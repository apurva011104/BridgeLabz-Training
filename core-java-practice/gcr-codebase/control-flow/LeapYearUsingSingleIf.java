import java.util.Scanner;

public class LeapYearUsingSingleIf {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year=scan.nextInt();
        boolean isLeapYear=false;
        //Checking for leap year
        if((year>=1582) && ((year%4==0 && year%100!=0) || (year%400==0))){
            isLeapYear=true;
        }
        System.out.println(year+" is "+(isLeapYear ? "" : "not ")+"a leap year");
        scan.close();
    }
}
