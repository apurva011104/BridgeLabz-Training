
import java.util.function.Function;

public class StringLengthChecker {
    
    private static Function<String, Integer> length = (String string) ->{
        return string==null?0:string.length();
    };

    public static boolean checkIfExceedsLimit(String string, int charactersLimit){
        if(charactersLimit<0){
            throw new IllegalArgumentException("Invalid character limit");
        }
        return length.apply(string) > charactersLimit;
    }
    
    public static void main(String[] args) {
        String string1 = "This string exceeds the character limit";
        String string2 = "I am a string within the limit";
        int limit = 35;

        System.out.println("Do string1 exceeds limit?: "+checkIfExceedsLimit(string1, limit));
        System.out.println("Do string2 exceeds limit?: "+checkIfExceedsLimit(string2, limit));
    }
}
