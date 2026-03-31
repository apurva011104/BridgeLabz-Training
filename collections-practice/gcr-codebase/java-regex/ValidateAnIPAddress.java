import java.util.Scanner;

public class ValidateAnIPAddress {

    public static boolean validateIPAddress(String ipAddress){

        final String IP_REGEX = "(25[0-5]|2[0-4][0-9]|[01]?[0-9]{1,2})(\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9]{1,2})){3}";
        return ipAddress.matches(IP_REGEX);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ipAddress: ");
        String ipAddress = scanner.nextLine();

        boolean isValid = validateIPAddress(ipAddress);
        System.out.println("IP Address is "+(isValid?"valid":"invalid"));

        scanner.close();
    }
}
