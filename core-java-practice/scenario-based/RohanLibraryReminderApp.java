import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class RohanLibraryReminderApp {

    //method to take data input
    public static LocalDate takeDateInput(Scanner scan , DateTimeFormatter formatter){
        LocalDate localDate = null;
        while(true){
            String date=scan.next();
            try {
                localDate = LocalDate.parse(date, formatter);
                return localDate;
            } 
            catch (Exception e) {
                System.out.print("Invalid date value. Enter again: ");
            }
        }
    }

    //Method to check wheter fine is applied or not
    public static boolean isFineApplied(LocalDate returnDate, LocalDate dueDate){
        return returnDate.isAfter(dueDate);
    }

    //Method to count number of days
    public static int countDays(LocalDate dueDate, LocalDate returnDate){
        long daysBetween = ChronoUnit.DAYS.between(dueDate,returnDate);
        return (int)daysBetween;
    }

    //Method to calculate fine
    public static int calculateFine(LocalDate returnDate, LocalDate dueDate){
        int numberOfDays = countDays(dueDate, returnDate);
        return numberOfDays * 5;
    }

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT);

        for(int i=0 ; i<5 ; i++){
            System.out.println("Book "+(i+1));

            System.out.print("Enter due date: ");
            LocalDate dueDate = takeDateInput(scan, formatter);
            System.out.print("Enter return date: ");
            LocalDate returnDate =  takeDateInput(scan, formatter);

            boolean isFineApplied = isFineApplied(returnDate, dueDate);
            
            int fine = isFineApplied?calculateFine(returnDate,dueDate):0;

            System.out.println("Fine: "+fine);
            System.out.println("--------------------------------------------------------------");
        }

        scan.close();
    }
}
