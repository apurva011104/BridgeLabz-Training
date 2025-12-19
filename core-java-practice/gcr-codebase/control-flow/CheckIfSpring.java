import java.util.Scanner;

public class CheckIfSpring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the month number (1-12): ");
        int month = scan.nextInt();

        System.out.print("Enter the date (1-31): ");
        int date=scan.nextInt();

        if(date<1 || date>31 || month<1 || month>12){
            System.out.println("Invalid date or month.");
            scan.close();
            return;
        }

        if((month==3 && date>=20) || (month==6 && date<=20) || (month==4 && date<=30) || (month==5 && date<=31)){
            System.out.println("It is Spring.");
        }
        else if((month==2 && date>29) || ((month==4 || month==6 || month==9 || month==11) && date>30)){
            System.out.println("Invalid date");
        }
        else {
            System.out.println("It is not Spring.");
        }
        
        scan.close();
    }
}