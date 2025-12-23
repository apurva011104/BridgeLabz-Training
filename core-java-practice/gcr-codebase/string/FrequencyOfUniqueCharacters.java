import java.util.ArrayList;
import java.util.Scanner;

public class FrequencyOfUniqueCharacters {

    public static ArrayList<Character> uniqueCharacters(String text){
        boolean []characters=new boolean[256];
        ArrayList<Character> unique=new ArrayList<>();

        for(char ch : text.toCharArray()){
            if(!characters[ch]){
                unique.add(ch);
                characters[ch]=true;
            }
        }
        return  unique;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scan.next();

        ArrayList<Character> unique=uniqueCharacters(text);

        int []frequency= new int[256];

        for(char character: text.toCharArray()){
            frequency[character]++;
        }

        System.out.println("Character     Frequency");
        for(char ch: unique){
            System.out.println("    "+ch+"             "+frequency[ch]);
        }
    }
}
