import java.util.Scanner;

public class ValidateASocialSecurityNumber {

    public static boolean isValidSSN(String ssn){
        if(ssn==null){
            throw new IllegalArgumentException("SSN cannot be null.");
        }
        ssn = ssn.replaceAll("\\s+", "");
        final String SSN_REGEX = "[0-9]{3}-[0-9]{2}-[0-9]{4}";
        if(ssn.matches(SSN_REGEX)){
            String[] ssnParts = ssn.split("-");
            if(ssnParts[0].equals("000") || ssnParts[0].equals("666") || ssnParts[0].matches("9[0-9]{2}") || ssnParts[1].equals("00") || ssnParts[2].equals("0000")){
                return false;
            }
            return true;
        }
        return false;

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your Social Security Number: ");
        String ssn = scan.nextLine().trim();

        boolean isValidSSN = isValidSSN(ssn);

        System.out.println(ssn + " is " + (isValidSSN?"valid":"invalid"));

        scan.close();
    }
}
