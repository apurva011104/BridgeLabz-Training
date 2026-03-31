
import java.util.Arrays;

public class ConcatenateStrings {
    
    public static String concatenateString(String[] stringsArray){
        StringBuffer stringBuffer = new StringBuffer();

        for(String string: stringsArray){
            stringBuffer.append(string);
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }
    public static void main(String[] args) {
        
        String[] stringsArray = {"Write a program","that uses","StringBuffer","to concatenate","all the strings in the array","efficiently"};
        System.out.println("String array: "+Arrays.toString(stringsArray));
        System.out.println("Concatenated string: "+concatenateString(stringsArray));
    }

}
