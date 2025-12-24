import java.util.Scanner;

public class DistributeChocolates {
    public static int[] distributeChocolates(int chocolates, int children){
        int quotient=chocolates/children;
        int remainder=chocolates%children;
        return new int[]{quotient,remainder};
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter chocolates: ");
        int chocolates= scan.nextInt();
        System.out.print("Enter children: ");
        int children= scan.nextInt();
        if(children==0){
            System.out.println("NO children to give chocolates");
        }
        else{
            int []distributeChocolates = distributeChocolates(chocolates,children);
            System.out.println("No. of chocolates each child gets: "+distributeChocolates[0]);
            System.out.println("Remaining chocolates: "+distributeChocolates[1]);
        }
        scan.close();
    }
}
