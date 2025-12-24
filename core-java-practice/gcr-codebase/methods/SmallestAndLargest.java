import java.util.Scanner;

public class SmallestAndLargest {

    public static int smallest(int []numbers){
        int min=numbers[0];
        for(int i=0;i<numbers.length;i++){
            min=Math.min(min,numbers[i]);
        }
        return min;
    }
    public static int largest(int []numbers){
        int max=numbers[0];
        for(int i=0;i<numbers.length;i++){
            max=Math.max(max,numbers[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int []numbers=new int[3];
        for(int i=0;i<3;i++){
            System.out.print("Enter an integer: ");
            numbers[i]=scan.nextInt();
        }
        int smallest=smallest(numbers);
        int largest=largest(numbers);
        System.out.println("Largest number: "+largest);
        System.out.println("Smallest number: "+smallest);
    }
}
