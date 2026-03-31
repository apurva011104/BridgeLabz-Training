import java.util.Scanner;

public class SpringSeason {

    public static boolean validateDate(int date , int month){
        if(date<1 || date>31 || month<1 || month>12){
            return false;
        }
        if(month==2 && date>29){
            return false;
        }
        if((month==4 || month==6  || month==9 || month==11) && date>30){
            return false;
        }
        return true;
    }

    public static boolean isSpringSeason(int date, int month){
        if((month==3 && date>=20) || month==4  || month==5 || (month==6 && date<=20)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month  =  scan.nextInt();
        System.out.print("Enter date (1-31): ");
        int date  =  scan.nextInt();
        if(validateDate(date, month)){
            System.out.println("Invalid date!");
        }
        else{
            if(isSpringSeason(date, month)){
                System.out.println("It is spring season");
            }
            else{
                System.out.println("It is not spring season");
            }
        }
        scan.close();
    }
}
