import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DateFormatUtility{
    
    public static void main(String[] args) {
        String date = "01-07-2004";

        List<String> variousDateFormats = DateFormatterUtil.formatDate(date);

        for(String d: variousDateFormats){
            System.out.println(d);
        }
    }
}

interface DateFormatterUtil{
    static List<String> formatDate(String date){
        DateTimeFormatter[] formatters = {
                                            DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT),
                                            DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT),
                                            DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT),
                                            DateTimeFormatter.ofPattern("uuuu/MM/dd").withResolverStyle(ResolverStyle.STRICT),
                                            DateTimeFormatter.ofPattern("dd-MMMM-uuuu",Locale.ENGLISH).withResolverStyle(ResolverStyle.STRICT),
                                            DateTimeFormatter.ofPattern("dd/MMMM/uuuu",Locale.ENGLISH).withResolverStyle(ResolverStyle.STRICT),
                                            DateTimeFormatter.ofPattern("uuuu-MMMM-dd",Locale.ENGLISH).withResolverStyle(ResolverStyle.STRICT),
                                            DateTimeFormatter.ofPattern("uuuu/MMMM/dd",Locale.ENGLISH).withResolverStyle(ResolverStyle.STRICT),
                                        };
        LocalDate dateToFormat = null;

        for(DateTimeFormatter formatter: formatters){
            try {
                dateToFormat= LocalDate.parse(date,formatter);
                break;
            } 
            catch (DateTimeParseException e) {
            }
        }

        if(dateToFormat==null){
            throw new IllegalArgumentException("Invalid date or invalid date format.");
        }

        List<String> variousFormats = new ArrayList<>();

        for(DateTimeFormatter formatter: formatters){
            variousFormats.add(dateToFormat.format(formatter));
        }

        return variousFormats;
    }
}