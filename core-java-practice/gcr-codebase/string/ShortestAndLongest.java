import java.util.ArrayList;
import java.util.Scanner;

public class ShortestAndLongest {
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

    public static String[] splitString(String text){
        ArrayList<String> listOfWords = new ArrayList<>();
        int length=stringLength(text);

        while(length>0 && text.charAt(length-1)==' '){
            length--;
        }
        
        text=text.substring(0,length);
        int index=0;

        while(index < length){
            int left=index;
            while(index<length && text.charAt(index)!=' '){
                index++;
            }
            if(left!=index){
                listOfWords.add(text.substring(left,index));
            }
            index++;
        }
        String []words = listOfWords.toArray(new String[0]);
        return words;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scan.nextLine();
        String[] splitString = splitString(text);
        if(splitString.length==0){
            System.out.println("No word found in the string.");
            return;
        }
        String []shortestAndLongestString=new String[2];
        shortestAndLongestString[0]=splitString[0];
        shortestAndLongestString[1]=splitString[1];
        int shortestAndLongestLength[] = new int[2];
        shortestAndLongestLength[0]=stringLength(splitString[0]);
        shortestAndLongestLength[1]=stringLength(splitString[1]);
        for(String word : splitString){
            int len=stringLength(word);
            if(shortestAndLongestLength[0]>len){
                shortestAndLongestString[0]=word;
                shortestAndLongestLength[0]=len;
            }
            if(shortestAndLongestLength[1]<len){
                shortestAndLongestString[1]=word;
                shortestAndLongestLength[1]=len;
            }
        }

        System.out.println("Shortest word: "+shortestAndLongestString[0]);
        System.out.println("Shortest length: "+shortestAndLongestLength[0]);
        System.out.println("Longest word: "+shortestAndLongestString[1]);
        System.out.println("Longest length: "+shortestAndLongestLength[1]);
    }
}
