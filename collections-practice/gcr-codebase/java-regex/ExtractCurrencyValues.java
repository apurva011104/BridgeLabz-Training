import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCurrencyValues {

    public static List<String> extractCurrencyValues(String text){
        if(text==null){
            throw new IllegalArgumentException("Text cannot be null.");
        }

        final String PUNCTUATION_MARKS = ".?!,:;'\"";

        List<String> extractedCurrencyValues = new ArrayList<>();

        final Pattern CURRENCY_REGEX = Pattern.compile("(\\$)?[0-9]+\\.[0-9]+");
        Matcher matcher = CURRENCY_REGEX.matcher(text);

        while(matcher.find()){
            extractedCurrencyValues.add(matcher.group());
        }
        
        return extractedCurrencyValues;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = scan.nextLine();

        List<String> extractedCurrencyValues = extractCurrencyValues(text);

        if(extractedCurrencyValues.isEmpty()){
            System.out.println("No currency values found in the text");
        }
        else{
            System.out.print(""+extractedCurrencyValues.get(0));
            for(int i=1; i<extractedCurrencyValues.size(); i++){
                System.out.print(", "+extractedCurrencyValues.get(i));
            }
        }
        scan.close();
    }
}
