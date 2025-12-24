import java.util.Scanner;

public class NumberOfHandshakes {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numberOfStudents = scan.nextInt();
        int maximumHandshakes=maximumNumberOfHandshakes(numberOfStudents);
        System.out.println("Maximum number of handshakes: "+maximumHandshakes);
    }

	public static int maximumNumberOfHandshakes(int numberOfStudents) {
		int maxHandshakesCount = (numberOfStudents * (numberOfStudents -1)) / 2;
		return maxHandshakesCount;
	}
}
