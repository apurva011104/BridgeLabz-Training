import java.util.Scanner;

public class LongestWordInASentence {

    public static String longestWord(String sentence){
        String longestWord ="";
        int longestLength=0;
        int index=0;
        while(index<sentence.length()){
            int left = index;
            while(index<sentence.length() && (sentence.charAt(index)>='a' && sentence.charAt(index)<='z')){
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
        // String sentence = "the big red fox jumped over the fence";
        //System.out.println("Longest word: "+longestWord(sentence));
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text=  scan.nextLine().trim();
        System.out.println("Longest word: "+longestWord(text));
        scan.close();
    }
}
