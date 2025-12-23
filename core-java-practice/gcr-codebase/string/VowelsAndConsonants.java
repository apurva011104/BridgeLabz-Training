import java.util.Scanner;

public class VowelsAndConsonants {

    final String vowels="aeiouAEIOU";
    final String consonants="bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";

    public static int[] vowelsConsonantsAndNotALetterCount(String text){
        final String vowels="aeiouAEIOU";
        final String consonants="bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        int []charactersCount=new int[3];

        for(char ch: text.toCharArray()){
            if(vowels.contains(ch+"")){
                charactersCount[0]++;
            }
            else if(consonants.contains(ch+"")){
                charactersCount[1]++;
            }
            else{
                charactersCount[2]++;
            }
        }

        return charactersCount;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scan.nextLine();
        
        int []countVowelsConsonantsAndNotLetters= vowelsConsonantsAndNotALetterCount(text);

        System.out.println("No. of vowels: "+countVowelsConsonantsAndNotLetters[0]);
        System.out.println("No. of consonants: "+countVowelsConsonantsAndNotLetters[1]);
        System.out.println("No. of non-letters: "+countVowelsConsonantsAndNotLetters[2]);
    }
    
}
