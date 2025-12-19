import java.util.Scanner;

public class CalculatePrice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the price of the item: ");
        double price = scan.nextDouble();
        System.out.println("Enter quantity of the item: ");
        int quantity = scan.nextInt();
        double totalPrice = price * quantity;
        System.out.println("The total purchase price is INR " + totalPrice + " if the quantity purchased is " + quantity + " and the price per item is INR " + price + ".");
        scan.close();
    }
}
