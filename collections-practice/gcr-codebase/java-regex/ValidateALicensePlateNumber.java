import java.util.Scanner;

public class ValidateALicensePlateNumber {

    public static boolean isValid(String licenseNumber){
        String regex = "[A-Z]{2}[0-9]{4}";
        return licenseNumber.matches(regex);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter license number: ");
        String licenseNumber = scanner.nextLine().trim();

        boolean isValid = isValid(licenseNumber);

        System.out.println("License Number is "+(isValid?"Valid":"Invalid"));

        scanner.close();
    }
}
