import java.util.Scanner;

public class SubstringOccurrences {

    public static int countSubstringOccurences(String text, String substring){
        int count=0;
        for(int i=0;i<=text.length()-substring.length();i++){
            if(text.substring(i,i+substring.length()).equals(substring)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text=  scan.next();
        System.out.print("Enter a substring: ");
        String substring =  scan.next();
        System.out.println("Substring occurences in text: "+countSubstringOccurences(text, substring));
        scan.close();
    }
}
