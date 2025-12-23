import java.util.ArrayList;
import java.util.Scanner;


public class UniqueCharacters {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scan.next();
    
        boolean []characters=new boolean[256];
        ArrayList<Character> unique=new ArrayList<>();

        for(char ch : text.toCharArray()){
            if(!characters[ch]){
                unique.add(ch);
                characters[ch]=true;
            }
        }

        System.out.println("Unique characters in string: ");
        for(char ch: unique){
            System.out.print(ch+", ");
        }
    }
}
