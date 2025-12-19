import java.util.Scanner;

public class CountToOne {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.print("Enter an integer:");
        int counter= scan.nextInt();
        if(counter<1){
            System.out.println("Not a positive integer.");
        } 
        else{
            while(counter>=1){
                System.out.println(counter);
                counter--;
            }
        }
        scan.close();
    }
}
