import java.util.Scanner;

public class ReplaceMultipleSpacesWithASingleSpace {

    public static String replaceSpaces(String text){
        return text.replaceAll("\\s+"," ");
    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = scan.nextLine().trim();

        String newText = replaceSpaces(text);

        System.out.println(newText);
    }
}
