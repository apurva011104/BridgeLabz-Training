import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = scan.nextInt();

        String []fizzBuzz=new String[num];
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzz[i-1]="FizzBuzz";
            }
            else if (i % 3 == 0) {
                fizzBuzz[i-1]="Fizz";
            }
            else if (i % 5 == 0) {
                fizzBuzz[i-1]="Buzz";
            }
            else {
                fizzBuzz[i-1]=""+i;
            }
        }

        for(int i=0;i<num;i++){
            System.out.println((i+1)+". "+fizzBuzz[i]);
        }
        scan.close();
    }
}
