import java.util.Scanner;

public class VowelsConsonantsNotALetter {

    public static int stringLength(String str){
        int index=0;
        try {
            while(true){
                char ch=str.charAt(index);
                index++;
            }
        }
        catch (Exception e) {}
        return index;
    }

    public static String[][] vowelsConsonantsAndNotALetter(String text){
        final String vowels="aeiouAEIOU";
        final String consonants="bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";

        int len=stringLength(text);
        String [][]characters=new String[len][2];

        for(int i=0; i<len ; i++){
            char ch=text.charAt(i);
            characters[i][0]=ch+"";
            if(vowels.contains(ch+"")){
                characters[i][1]="Vowel";
            }
            else if(consonants.contains(ch+"")){
                characters[i][1]="Consonant";
            }
            else{
                characters[i][1]="Not a letter";
            }
        }

        return characters;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scan.nextLine();
        
        String [][]vowelsConsonantsAndNotALetter= vowelsConsonantsAndNotALetter(text);

        for(String []character: vowelsConsonantsAndNotALetter){
            System.out.println(character[0]+": "+character[1]);
        }

    }

}
