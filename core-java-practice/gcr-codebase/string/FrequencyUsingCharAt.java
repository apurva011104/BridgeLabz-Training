import java.util.Scanner;

public class FrequencyUsingCharAt {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scan.next();

        int []frequency= new int[256];

        for(int i=0;i<text.length() ;i++){
            frequency[text.charAt(i)]++;
        }

        System.out.println("Character     Frequency");
        for(int i=0;i<text.length() ;i++){
            char ch=text.charAt(i);
            System.out.println("    "+ch+"             "+frequency[ch]);
        }

    }
}
