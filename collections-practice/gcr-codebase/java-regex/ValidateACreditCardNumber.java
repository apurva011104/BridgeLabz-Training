import java.util.Scanner;

public class ValidateACreditCardNumber {

    public static boolean isValidCreditCardNumber(String creditCardNumber){

        final String CREDIT_CARD_REGEX = "^[45][0-9]{15}$";
        return creditCardNumber.matches(CREDIT_CARD_REGEX);

    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter credit card number: ");
        String creditCardNumber = scanner.nextLine();
        boolean isValid = isValidCreditCardNumber(creditCardNumber);

        System.out.println("Credit card number is "+(isValid?"valid":"invalid"));

        scanner.close();
    }
}
