import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CensorBadWords {

    public static String generateRegex(String text){
        StringBuilder regex = new StringBuilder();
        regex.append("\\b");
        for(char ch: text.toCharArray()){
            regex.append("[");
            if(Character.isAlphabetic(ch)){
                regex.append(Character.toLowerCase(ch));
                regex.append(Character.toUpperCase(ch));
            }
            else{
                regex.append(ch);
            }
            regex.append("]");
        }
        regex.append("\\b");
        return regex.toString();
    }

    public static String censorBadWords(String text){
        List<String> badWords = new ArrayList<>(Arrays.asList("damn","stupid","bloody","bitch","shit","crap","hell","retard","fuck","moron","asshole"));

        final String CENSORED_WORD = "****";

        for(String badWord: badWords){
            String regex = generateRegex(badWord);
            text = text.replaceAll(regex, CENSORED_WORD);
        }

        return text;
    }

    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the sentence: ");
        String sentence = scan.nextLine();

        String censoredSentence = censorBadWords(sentence);

        System.out.println(censoredSentence);
    }
}
