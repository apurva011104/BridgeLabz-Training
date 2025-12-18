import java.util.Scanner;

public class feesToPay {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the total course fee: ");
        double totalFee = scan.nextDouble();                     //Takes total course fee input 
        System.out.print("Enter the discount percentage: ");         
        double discountPercentage = scan.nextDouble();           //Takes discount percentage input 
        double discount = (discountPercentage * totalFee) / 100.0;      //Calculates discount amount
        double finalFee = totalFee - discount;                  //Calculates final fee after discount
        System.out.println("The discount amount is INR " + discount + " and the final fee to pay is INR " + finalFee);
        scan.close();
    }
}
