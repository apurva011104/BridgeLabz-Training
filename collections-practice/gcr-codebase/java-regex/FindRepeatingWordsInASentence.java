import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class FindRepeatingWordsInASentence {


    public static List<String> findRepeatingWords(String text){
        if(text==null){
            throw new IllegalArgumentException("Text cannot be null.");
        }
        
        String[] allWords= text.split("\\W+");
        
        List<String> repeatingWords = new ArrayList<>();

        Map<String,Integer> frequency = new LinkedHashMap<>();

        for(String word: allWords){
            String lowercaseWord = word.toLowerCase();

            frequency.put(lowercaseWord, frequency.getOrDefault(lowercaseWord, 0) + 1);
        }

        for(Map.Entry<String, Integer> entry: frequency.entrySet()){
            if(entry.getValue()>1){
                repeatingWords.add(entry.getKey());
            }
        }

        return repeatingWords;
        
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = scan.nextLine();

        List<String> repeatingWords = findRepeatingWords(text);

        if(repeatingWords.isEmpty()){
            System.out.println("No repeating words found in the sentence");
        }
        else{
            String string = repeatingWords.toString();

            System.out.println(string.substring(1,string.length()-1));
        }

        scan.close();
    }
}
