import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Scanner;


public class DateArithmetic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Using formatter to check whether the user input date is valid
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT);
        LocalDate localDate = null;
        System.out.print("Enter date in the format 'dd-MM-yyyy': ");
        while(true){
            String date=scan.next();
            try {
                //Initializing date to localdate object. Using flag formatter to ensure that date is valid.
                localDate = LocalDate.parse(date, formatter);       //Will throw exception if date does not matches the pattern
                break;
            } 
            catch (Exception e) {
                System.out.print("Invalid date value. Enter again: ");
            }
        }

        //Performing operations 
        localDate=localDate.plusDays(7);
        localDate=localDate.plusMonths(1);
        localDate=localDate.plusYears(2);
        localDate=localDate.minusWeeks(3);

        //Displaying output
        System.out.println("Date after adding 7 days, 1 month and 2 years and subtracting 3 weeks: "+localDate);
    }
}
