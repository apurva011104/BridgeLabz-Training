import java.util.Scanner;

public class ArrayIndexOutOfBoundsExceptionExample {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        try {
            System.out.print("Enter number of names you want to insert: ");
            int length=scan.nextInt();
            String []names =new String[length];
            for(int i=0 ; i<length;i++){
                System.out.print("Enter a name: ");
                names[i]=scan.nextLine();
            }
            for(int i=0;i<=length;i++){
                System.out.println("Name "+i+": "+names[i]);
            }
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
