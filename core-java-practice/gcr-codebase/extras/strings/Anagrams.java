import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {

    public static int[]characterFrequency(String text){
        int []frequency=new int[256];
        for(char ch: text.toCharArray()){
            frequency[ch]++;
        }
        return frequency;
    }

    public static boolean isAnagram(String text1, String text2){
        int []frequency1=characterFrequency(text1);
        int []frequency2=characterFrequency(text2);
        return Arrays.toString(frequency1).equals(Arrays.toString(frequency2));
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter first text: ");
        String text1=scan.next();
        System.out.print("Enter second text: ");
        String text2=scan.next();
        System.out.println("Are \""+text1+"\" and \""+text2+"\" anagram strings? "+isAnagram(text1, text2));
        scan.close();
    }
}
