import java.util.Scanner;

public class LexicalTwist {

    static final String vowels="aeiouAEIOU";

    public static boolean isReverse(String word1, String word2){
        StringBuilder stringBuilder = new StringBuilder(word2);
        stringBuilder.reverse();
        return stringBuilder.toString().equalsIgnoreCase(word1);
    }

    public static String reverseString(String word){
        StringBuilder stringBuilder = new StringBuilder(word);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static String replaceVowels(String word){
        
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            stringBuilder.append(vowels.contains(ch+"")?"@":ch);
        }
        return stringBuilder.toString();
    }

    public static int[] countVowelsAndConsonants(String word){
        int[] count = new int[2];
        for(char ch: word.toCharArray()){
            if(Character.isAlphabetic(ch)){
                if(vowels.contains(ch+"")){
                    count[0]++;
                }
                else{
                    count[1]++;
                }
            }
        }
        return count;
    }

    public static void performTransformation(String word1, String word2){
        if(isReverse(word1, word2)){
            word1 = reverseString(word1);
            word1 = word1.toLowerCase();
            word1 = replaceVowels(word1);
            System.out.println(word1);
        }
        else{
            String word = word1+word2;
            word = word.toUpperCase();
            int[] count = countVowelsAndConsonants(word);
            String toPrint = "";
            if(count[0]>count[1]){
                for(char ch: word.toCharArray()){
                    if(vowels.contains(ch+"") && !toPrint.contains(ch+"")){
                        toPrint+=ch;
                    }
                    if(toPrint.length()==2){
                        break;
                    }
                }
            }
            else if(count[0]<count[1]){
                for(char ch: word.toCharArray()){
                    if(Character.isAlphabetic(ch) && !vowels.contains(ch+"") && !toPrint.contains(ch+"")){
                        toPrint+=ch;
                    }
                    if(toPrint.length()==2){
                        break;
                    }
                }
            }
            else{
                toPrint = "Vowels and consonants are equal";
            }

            System.out.println(toPrint);
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first word: ");
        String word1 = scanner.nextLine().trim();
        if(word1.contains(" ")){
            System.out.println(word1+" is an invalid word");
            return;
        }

        System.out.print("Enter the second word: ");
        String word2 = scanner.nextLine().trim();
        if(word2.contains(" ")){
            System.out.println(word2+" is an invalid word");
            return;
        }

        performTransformation(word1, word2);

    }
}
