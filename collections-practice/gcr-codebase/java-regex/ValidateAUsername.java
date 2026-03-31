import java.util.Scanner;

public class ValidateAUsername{

    public static boolean isValid(String username){
        final String usernameRegex = "[a-zA-Z]([a-zA-Z0-9_]{4,14})";
        return username.matches(usernameRegex);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();
        boolean isValid = isValid(username);

        System.out.println("Username is "+(isValid?"Valid":"Invalid"));

        scanner.close();
    }
}