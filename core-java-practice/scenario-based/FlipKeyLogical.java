import java.util.Scanner;

public class FlipKeyLogical {

    public String cleanseAndInvert(String input){
        if(input==null || input.length()<6){
            return "";
        }
        if(!input.matches("^[a-zA-Z]*$")){
            return "";
        }

        input = input.toLowerCase();
        StringBuilder password = new StringBuilder();

        for(char ch: input.toCharArray()){
            if(ch%2==1){
                password.append(ch);
            }
        }
        password.reverse();

        for(int i=0; i<password.length(); i+=2){
            char uppercase = (char)(password.charAt(i)-'a'+'A');
            password.replace(i, i+1, uppercase+"");
        }

        return password.toString();
    }

    public static void main(String[] args) {

        final Scanner SCANNER = new Scanner(System.in);
        final FlipKeyLogical flipKeyLogical = new FlipKeyLogical();

        System.out.println("Enter the word");
        String word = SCANNER.nextLine();

        String password = flipKeyLogical.cleanseAndInvert(word);

        if(password.equals("")){
            System.out.println("Invalid Input");
        }
        else{
            System.out.println("The generated key is - "+password);
        }
    }
}
