import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatting {
    public static void main(String[] args) {

        //Creating DateFormatters objects with different formats
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        //Fetching current date annd time
        LocalDateTime current = LocalDateTime.now();

        //Formatting date
        String formattedDate1 = current.format(formatter1);
        String formattedDate2 = current.format(formatter2);
        String formattedDate3 = current.format(formatter3);

        //Displaying results
        System.out.println("Current date in format 'dd/MM/yyyy': "+formattedDate1);
        System.out.println("Current date in format 'yyyy-MM-dd': "+formattedDate2);
        System.out.println("Current date in format 'EEE, MMM dd, yyyy': "+formattedDate3);
    }
}
