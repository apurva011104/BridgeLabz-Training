import java.util.Scanner;

public class StoringNumbersInAnArray {
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);

        double []numbers = new double[10];
        boolean isPositive=true;
        int index=0;
        while(isPositive && index<10){
            System.out.print("Enter a positive number to store in an array or enter zero or negative number to print their sum: ");
            double num=scan.nextDouble();
            if(num <= 0){
                isPositive=false;
            }
            else{
                numbers[index]=num;
                index++;
            }
        }

        double total=0.0;
        for(int i=0;i<10 ;i++){
            total+=numbers[i];
        }

        index=0;
        System.out.print("Numbers entered: ");
        while(index<10 && numbers[index]!=0.0){
            System.out.print(numbers[index]+" ");
            index++;
        }
        System.out.printf("\nTheir sum: %.2f",total);

        scan.close();
    }
}
