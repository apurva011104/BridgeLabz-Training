import java.util.Scanner;

public class MostFrequentCharacter {

    public static char mostFrequentCharacter(String text){
        char frequentCharacter = ' ';
        int []frequency= new int[256];
        for(char ch: text.toCharArray()){
            frequency[ch]++;
            if(frequency[ch]>frequency[frequentCharacter]){
                frequentCharacter=ch;
            }
        }
        return frequentCharacter;
    }

    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text=  scan.next();
        System.out.println("Most frequent character: "+mostFrequentCharacter(text));
        scan.close();
    }
}
