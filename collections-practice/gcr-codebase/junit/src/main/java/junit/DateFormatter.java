package junit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class DateFormatter {
    
    public static String formatDate(String inputDate){
        if(!validateDate(inputDate)){
            throw new IllegalArgumentException("Invalid date format or invalid date");
        }
        String[] dateParts = inputDate.split("-");
        return dateParts[2]+"-"+dateParts[1]+"-"+dateParts[0];
    }

    private static boolean validateDate(String inputDate){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT);
            LocalDate date = LocalDate.parse(inputDate);
            return true;
        } catch (DateTimeParseException e) {}
        return false;
    }
}
