import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeInDifferentTimezones {
    public static void main(String[] args) {
        //Getting Zone Ids
        ZoneId gmtId = ZoneId.of("GMT");
        ZoneId istId = ZoneId.of("Asia/Kolkata");
        ZoneId pstId = ZoneId.of("America/Los_Angeles");
        ZoneId systemDefault = ZoneId.systemDefault();

        //Getting date-time for particular zones
        ZonedDateTime currentTime = ZonedDateTime.now(systemDefault);
        ZonedDateTime gmtTime = ZonedDateTime.now(gmtId);
        ZonedDateTime istTime = ZonedDateTime.now(istId);
        ZonedDateTime pstTime = ZonedDateTime.now(pstId);

        //Initializing a formatter to convert date-time into reading format 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        //Displaying results
        System.out.println("Current time in your zone: "+currentTime.format(formatter));
        System.out.println("Current time in Greenwich mean time: "+gmtTime.format(formatter));
        System.out.println("Current time in Indian standard time: "+istTime.format(formatter));
        System.out.println("Current time in Pacific Standard Time: "+pstTime.format(formatter));
    }
}
