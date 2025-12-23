import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SplitString {

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
            listOfWords.add(text.substring(left,index));
            index++;
        }
        String []words = listOfWords.toArray(new String[0]);
        return words;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scan.nextLine();
        
        String [] splitString= splitString(text);
        String []splitUsingBuiltIn = text.split(" ");

        System.out.println("Splitting string using user-defined method: "+Arrays.toString(splitString));
        System.out.println("Splitting string usingbuilt-in method: "+Arrays.toString(splitUsingBuiltIn));
    }
}
