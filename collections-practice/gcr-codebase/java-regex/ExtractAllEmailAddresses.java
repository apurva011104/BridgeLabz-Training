import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtractAllEmailAddresses {

    private static boolean isAlphaNumeric(char ch){
        return Character.isAlphabetic(ch) || Character.isDigit(ch);
    }

    public static List<String> extractEmailAddresses(String text){
        if(text == null || text.length()==0){
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }

        final String EMAIL_REGEX = "[a-zA-Z0-9]+([._%+-][a-zA-Z0-9])*[@][a-zA-Z0-9]+[.][a-zA-Z]+([.][a-zA-Z])*";

        List<String> emailAddresses = new ArrayList<>();

        String[] words = text.split("\\s+");

        for(String word: words){
            int left=0;
            while(left<word.length() && !isAlphaNumeric(word.charAt(left))){
                left++;
            }
            int right=word.length();
            while(right>left && !isAlphaNumeric(word.charAt(right-1))){
                right--;
            }

            String newWord = word.substring(left,right);

            if(newWord.matches(EMAIL_REGEX)){
                emailAddresses.add(newWord);
            }
        }

        return emailAddresses;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = scan.nextLine();

        List<String> emailAddresses  = extractEmailAddresses(text);

        if(emailAddresses.isEmpty()){
            System.out.println("No email addresses found in the text");
        }
        else{
            System.out.println("Email address(es): ");
            for(String emailAddress: emailAddresses){
                System.out.println(emailAddress);
            }
        }

        scan.close();
    }
}
