import java.util.Scanner;

public class CheckAge {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter the age: ");
        int age=scan.nextInt();
        if(age>=18){
            System.out.println("The person can vote.");
        }
        else if(age>=0 && age<18){
            System.out.println("The person cannot vote.");
        }
        else{
            System.out.println("Not a valid age.");
        }
        scan.close();
    }    
}
