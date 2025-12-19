import java.util.Scanner;

public class handshakesCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents= scan.nextInt();
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
        System.out.println("The number of handshakes possible between "+ numberOfStudents + " students is: " + handshakes);
        scan.close();
    }
}
