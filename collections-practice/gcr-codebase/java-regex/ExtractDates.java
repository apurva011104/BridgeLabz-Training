import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtractDates {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);

    private static boolean isValidDate(String date){
        
        try {
            LocalDate localDate = LocalDate.parse(date, FORMATTER);
            return true;
        } 
        catch (DateTimeParseException e) {
            return false;
        }
    }

    private static boolean isDate(String word) {
        if(word.matches("\\d{2}/\\d{2}/\\d{4}")){
            return isValidDate(word);
        }
        return false;
    }

    public static List<String> extractDates(String text){
        if(text==null || text.isEmpty()){
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }

        List<String> extractedDates = new ArrayList<>();

        String[] words = text.split("\\s+");
        for(String word: words){
            int left=0;
            while(left<word.length() && !Character.isLetterOrDigit(word.charAt(left))){
                left++;
            }
            int right=word.length();
            while(right>left && !Character.isLetterOrDigit(word.charAt(right-1))){
                right--;
            }

            String newWord = word.substring(left,right);

            if(isDate(newWord)){
                extractedDates.add(newWord);
            }

        }
        return extractedDates;
    }
    
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = scan.nextLine();

        List<String> dates = extractDates(text);

        if(dates.isEmpty()){
            System.out.println("Text does not contains any date.");
        }
        else{
            for(String date: dates){
                System.out.println(date);
            }
        }
    }
}
