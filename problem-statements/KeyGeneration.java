
import java.util.Scanner;

public class KeyGeneration {

    public static void validateString(String s){
        if(s.trim().equals("")){
            throw new IllegalArgumentException("empty string");
        }
        if(s.length()<6){
            throw new IllegalArgumentException("Invalid Input (length<6)");
        }
        if(s.contains(" ")){
            throw new IllegalArgumentException("Invalid Input (contains space)");
        }
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                throw new IllegalArgumentException("Invalid Input (contains digit)");
            }
            if(!Character.isLetterOrDigit(ch)){
                throw new IllegalArgumentException("Invalid Input (contains special character)");
            }
        }
    }

    public static String generateKey(String s){
        validateString(s);

        String lower = s.toLowerCase();

        StringBuilder sb = new StringBuilder();

        for(char ch: lower.toCharArray()){
            if(ch%2==1){
                sb.append(ch);
            }
        }

        if(sb.isEmpty()){
            throw new IllegalArgumentException("Invalid Input (contains space)");
        }

        sb.reverse();

        StringBuilder key = new StringBuilder();

        for(int i=0 ; i<sb.length() ; i++){
            char ch = sb.charAt(i);
            if(i%2==0){
                ch = (char)(ch-'a'+'A');
            }
            key.append(ch);
        }

        return key.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for(int i=0 ; i<n ; i++){
            String s = scanner.nextLine();
            try {
                String generated = generateKey(s);
                System.out.println("The generated key is - " + generated);
            } 
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
