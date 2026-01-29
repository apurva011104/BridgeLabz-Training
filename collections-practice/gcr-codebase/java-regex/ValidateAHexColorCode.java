import java.util.Scanner;

public class ValidateAHexColorCode {

    public static boolean isValid(String hexcode ){
        return hexcode.matches("[#][a-fA-F0-9]{6}");
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter color's hex code: ");
        String hexcode = scanner.nextLine().trim();

        boolean isValid = isValid(hexcode);
        
        System.out.println("Hex color code is "+(isValid?"valid":"invalid"));

        scanner.close();
    }
}
