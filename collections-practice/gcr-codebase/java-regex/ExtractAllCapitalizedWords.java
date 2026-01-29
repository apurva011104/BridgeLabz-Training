import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtractAllCapitalizedWords {

    public static List<String> extractCapitalizedWords(String text){
        if(text == null || text.length()==0){
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }

        final String regex = "[A-Z][a-z]*";
        List<String> capitalizedWords = new ArrayList<>();
        String[] words= text.split("\\W+");

        for(String word: words){
            if(word.matches(regex)){
                capitalizedWords.add(word);
            }
        }
        return capitalizedWords;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = scan.nextLine();

        List<String> capitalizedWords = extractCapitalizedWords(text);

        if(capitalizedWords.isEmpty()){
            System.out.println("No capitalized words found in the text");
        }
        else{
            for (int i=0; i<capitalizedWords.size()-1; i++) {
                System.out.print(capitalizedWords.get(i)+", ");
            }
            System.out.println(capitalizedWords.get(capitalizedWords.size()-1));
        }
    }
}
