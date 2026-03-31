import java.util.Scanner;

public class PositiveNegativeOrZero {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Taking input of 5 numbers from user
        int []numbers = new int[5];     //Initialize an array of size 5
        for(int i=0 ; i<numbers.length ; i++){
            System.out.print("Enter a number: ");
            numbers[i]=scan.nextInt();
        }

        //Check if the number is Positive, Negative or Zero
        for(int i=0 ; i<numbers.length ; i++){

            if( numbers[i] > 0 ){
                //Check if the positive number is Even or Odd
                if( numbers[i] % 2 == 0 ){
                    System.out.println(numbers[i] + " is a Positive Even number.");
                }
                else {
                    System.out.println(numbers[i] + " is a Positive Odd number.");
                }
            }
            else if( numbers[i] < 0 ){
                System.out.println(numbers[i] + " is a Negative number.");
            }
            else {
                System.out.println(numbers[i] + " is Zero.");
            }

        }

        //Compare first and last number in the array
        int firstNumber = numbers[0];
        int lastNumber = numbers[numbers.length - 1];
        if(firstNumber > lastNumber){
            System.out.println("First number " + firstNumber + " is greater than last number " + lastNumber + ".");
        }
        else if(firstNumber < lastNumber){
            System.out.println("First number " + firstNumber + " is smaller than last number " + lastNumber + ".");
        }
        else{
            System.out.println("Both first number and last number are equal to " + firstNumber + ".");
        }

        scan.close();
    }
}
