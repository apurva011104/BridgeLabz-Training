import java.util.Scanner;

public class LongestWordInASentence {
    public static String longestWord(String sentence){
        String longestWord ="";
        int longestLength=0;
        int index=0;
        while(index<sentence.length()){
            int left = index;
            while(index<sentence.length() && sentence.charAt(index)!=' '){
                index++;
            }
            if(longestLength<(index-left)){
                longestLength=index-left;
                longestWord=sentence.substring(left,index);
            }
            index++;
        }
        return longestWord;
    }
    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text=  scan.nextLine();
        System.out.println("Longest word: "+longestWord(text));
        scan.close();
    }
}
