import java.util.Scanner;

public class EmailValidator {

    public static boolean validateEmail(String email){
        String emailRegex = "[a-z]{3,}\\.[a-z]{3,}[0-9]{4,}@(sales|marketing|IT|product)\\.company.com";
        return email.matches(emailRegex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        for(int i=0 ; i<n ; i++){
            String email = scanner.nextLine();
            System.out.println(validateEmail(email)?"Access Granted":"Access Denied");
        }

        scanner.close();
    }
}
