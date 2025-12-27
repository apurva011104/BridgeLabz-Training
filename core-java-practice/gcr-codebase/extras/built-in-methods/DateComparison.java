import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class DateComparison {

    public static LocalDate takeDateInput(Scanner scan , DateTimeFormatter formatter){
        LocalDate localDate = null;
        while(true){
            String date=scan.next();
            try {
                localDate = LocalDate.parse(date, formatter);
                break;
            } 
            catch (Exception e) {
                System.out.print("Invalid date value. Enter again: ");
            }
        }
        return localDate;
    }


    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT);
        System.out.print("Enter date in the format 'dd-MM-yyyy': ");
        LocalDate localDate1 = takeDateInput(scan, formatter);
        System.out.print("Enter date in the format 'dd-MM-yyyy': ");
        LocalDate localDate2 = takeDateInput(scan, formatter);

        boolean isBefore = localDate1.isBefore(localDate2);
        boolean isAfter = localDate1.isAfter(localDate2);
        
        if(isBefore){
            System.out.println(localDate1+" is before "+localDate2);
        }
        else if(isAfter){
            System.out.println(localDate1+" is after "+localDate2);
        }
        else{
            System.out.println("Both dates are equal to "+localDate1);
        }
        
        
    }
}
