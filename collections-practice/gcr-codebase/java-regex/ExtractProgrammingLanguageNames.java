import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExtractProgrammingLanguageNames {

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

    public static List<String> ExtractProgrammingLanguages(String text){

        if(text == null || text.length()==0){
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }

        final String punctuationMarks = ".?!,:;'\"";
        final List<String> programmingLanguages = Arrays.asList("Java","Python","C++","C","Javascript","Go","Ruby","Lua","C#","SQL","HTML","CSS");

        final List<String> languagesRegex = new ArrayList<>();
        for (String language: programmingLanguages) {
            languagesRegex.add(generateRegex(language));
        }

        List<String> extractedProgrammingLanguages = new ArrayList<>();

        String[] words = text.split("\\s+");

        for(String word: words){
            String newWord= word;
            if (punctuationMarks.contains(newWord.charAt(0)+"")) {
                newWord=newWord.substring(1);
            }
            if(punctuationMarks.contains(newWord.charAt(newWord.length()-1)+"")){
                newWord=newWord.substring(0,newWord.length()-1);
            }
            //System.out.println(newWord);
            for(String languageRegex : languagesRegex){
                if(newWord.matches(languageRegex)){
                    extractedProgrammingLanguages.add(newWord);
                }
            }
        }

        return extractedProgrammingLanguages;
    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = scan.nextLine();

        List<String> extractedProgrammingLanguages = ExtractProgrammingLanguages(text);

        if(extractedProgrammingLanguages.isEmpty()){
            System.out.println("No programming language found in the text");
        }
        else{
            //System.out.print(extractedProgrammingLanguages);
            System.out.print(""+extractedProgrammingLanguages.get(0));
            for(int i=1; i<extractedProgrammingLanguages.size() ;i++){
                System.out.print(", "+extractedProgrammingLanguages.get(i));
            }
        }
    }
}
