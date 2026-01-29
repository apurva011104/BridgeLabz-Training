import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtractLinksFromAWebPage {

    public static List<String> extractLinks(String text){
        if(text==null || text.isEmpty()){
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }

        final String LINK_REGEX = "(http(s)?://)?(www\\.)?[a-zA-Z0-9]+([\\.][a-zA-Z0-9])*[\\.][a-zA-Z0-9]+(/[a-zA-Z0-9._-]*)*";

        List<String> links = new ArrayList<>();

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
            //System.out.println(newWord);
            if(newWord.matches(LINK_REGEX)){
                links.add(newWord);
            }

        }
        return links;
    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = scan.nextLine();

        List<String> links = extractLinks(text);

        if(links.isEmpty()){
            System.out.println("Text does not contains any link.");
        }
        else{
            for(String link: links){
                System.out.println(link);
            }
        }

        scan.close();
    }
}
