import java.util.Scanner;

public class CoffeeCounterChronicles {

    // Coffee types and their respective prices in INR
    static String []coffeeTypes = {"Espresso", "Latte", "Cappuccino", "Americano", "Mocha","Chai Tea Latte","Milk Coffee","Black Coffee","Cold Coffee","Iced Latte"};
    static double []perCupCoffeePricesINR= {100.0, 120.0, 130.0, 110.0, 140.0, 90.0, 80.0, 70.0, 150.0, 160.0};
    static final int gstPercentage=5;
    static int numberOfCoffeeTypes=coffeeTypes.length;

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        boolean isCustomerPresent=true;

        while(isCustomerPresent){

            System.out.println("Welcome to Coffee Counter Chronicles!");

            // Display coffee menu
            System.out.println("Select a coffee type from the menu below:");
            for(int i=0; i<numberOfCoffeeTypes; i++){
                System.out.println("Select " + (i+1) + " for " + coffeeTypes[i] + " (INR " + perCupCoffeePricesINR[i] + ")");
            }

            // Get customer choice
            int coffeeTypeSelected=1;
            System.out.print("Enter your choice: ");
            coffeeTypeSelected=scan.nextInt();
            if(coffeeTypeSelected<1 || coffeeTypeSelected>numberOfCoffeeTypes){
                System.out.println("Invalid choice. Please select a valid coffee type.");
                continue;
            }
            // Get number of cups
            System.out.print("Enter the number of cups: ");
            int numberOfCups=scan.nextInt();
            if(numberOfCups<=0){
                System.out.println("Invalid number of cups. Please enter a positive integer.");
                continue;
            }

            // Calculate bill
            double totalBill=perCupCoffeePricesINR[coffeeTypeSelected-1]*numberOfCups;
            double gstAmount=(totalBill*gstPercentage)/100;
            double finalBill=totalBill+gstAmount;  
            
            // Display bill details
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Bill Details:");
            System.out.println("Coffee Type:        " + coffeeTypes[coffeeTypeSelected-1]);
            System.out.println("Number of Cups:     " + numberOfCups);
            System.out.printf("Total Bill (INR):    %.2f\n", totalBill);
            System.out.printf("GST Amount (INR):    %.2f\n", gstAmount);
            System.out.printf("Final Bill (INR):    %.2f\n", finalBill);
            System.out.println("Thank you for visiting Coffee Counter Chronicles! Have a great day!");
            System.out.println("-------------------------------------------------------------------");

            // Check for next customer
            System.out.print("Is there another customer? If yes, enter \"next\" else enter \"exit\": ");
            String customerResponse=scan.next();
            if(customerResponse.equalsIgnoreCase("exit")){
                isCustomerPresent=false;
            }
        }

        scan.close();
    }

}
