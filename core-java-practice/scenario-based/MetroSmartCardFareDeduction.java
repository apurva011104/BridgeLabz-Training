import java.util.Scanner;

public class MetroSmartCardFareDeduction {

    public static double calculatePrice(double distance){
        if(distance>0 && distance<=5){
            return 11;
        }
        if(distance>5 && distance<=12){
            return 23;
        }
        if(distance>12 && distance<=20){
            return 35;
        }
        if(distance>20 && distance<=32){
            return 47;
        }
        if(distance>32 && distance<=50){
            return 59;
        }
        if(distance>50){
            return 71;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter the amount in your card (in INR): ");
        double cardAmount = scan.nextDouble();
        double totalDistanceCovered=0;
        double totalAmountSpent=0;

        while(cardAmount>0){
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Price chart according to distance (in kms): ");
            System.out.println("0 - 5km : INR 11");
            System.out.println("5km - 12km : INR 21");
            System.out.println("12km - 20km : INR 32");
            System.out.println("20km - 32km : INR 43");
            System.out.println("32km - 50km : INR 54");
            System.out.println("50km - 100km : INR 70");
            System.out.print("Enter travel distance in kms (0-100)");
            double distance=scan.nextDouble();

            while(distance<0 || distance>100){
                System.out.print("You can only travel the distance in the range (0,100] kms. Enter distance again: ");
                distance=scan.nextDouble();
            }
            double price = calculatePrice(distance);

            if(price>cardAmount){
                System.out.println("Sorry you can't travel this distance. Card balance is not enough.");
            }
            else{
                totalDistanceCovered+=distance;
                totalAmountSpent+=price;
                cardAmount-=price;
                System.out.println("Card balance: "+cardAmount);
                System.out.println("Thank you for travelling :)");
            }
            System.out.print("Do you want to travel more? Enter 'yes' or 'no': ");
            String travelMore=scan.next().toLowerCase();
            while(!travelMore.equals("yes") && !travelMore.equals("no")){
                System.out.print("Invalid input! Enter either 'yes' or 'no': ");
                travelMore=scan.next().toLowerCase();
            }
            if(travelMore.equals("no")){
                break;
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Total Distance travelled: "+totalDistanceCovered);
        System.out.println("Total amount spent: "+totalAmountSpent);
        System.out.println("Card balance: "+cardAmount);
    }
}
