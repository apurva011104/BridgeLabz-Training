import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomExceptionExample {

    public static boolean validateAge(int age) throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("Age must be 18 or above.");
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
            boolean isAgeValid = validateAge(age);
            if(isAgeValid){
                System.out.println("Access granted!");
            }
        } 
        catch (InvalidAgeException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        
    }
}

class InvalidAgeException extends Exception{

    public InvalidAgeException(String message){
        super(message);
    }
}