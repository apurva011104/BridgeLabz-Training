import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyCounter {

    public static Map<String, Integer> countFrequency(String sentence){
        List<String> words = new ArrayList<>();

        Map<String, Integer> frequency = new HashMap<>();
        
        int index = 0;
        while(index<sentence.length()){
            int left = index;
            while(index<sentence.length()){
                char ch = sentence.charAt(index);
                if(Character.isDigit(ch) || Character.isAlphabetic(ch)){
                    index++;
                }
                else{
                    break;
                }
            }
            if(left!=index){
                String word = sentence.substring(left, index).toLowerCase();
                frequency.put(word, frequency.getOrDefault(word, 0)+1);
            }

            index++;
        }

        return frequency;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sentence = scanner.nextLine();

        Map<String, Integer> frequency = countFrequency(sentence);

        System.out.println("Word frequency: "+frequency);

    }
}
