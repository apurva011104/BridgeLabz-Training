import java.util.Scanner;

public class SumOfNaturalNumbersUsingForLoop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = scan.nextInt();
        if(num <1){
            System.out.println("Not a natural number.");
        } 
        else{
            int sum = 0;
            for(;num>0;num--){
                sum += num;
            }
            int sumUsingFormula = (num * (num + 1)) / 2;
            boolean isCorrect = (sum == sumUsingFormula);
            if(isCorrect){
                System.out.printf("The sum of %d natural numbers using formula %d and using loop %d are equal.",num,sumUsingFormula,sum);
            }
            else{
                System.out.printf("The sum of %d natural numbers using formula %d and using loop %d are not equal.",num,sumUsingFormula,sum);
            }
        }
        scan.close();
    }
}
