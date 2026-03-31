
import java.util.ArrayList;
import java.util.Scanner;

public class CafeteriaMenuApp {
    
    private static final String[] menuItems={"Milkshake","Cold drink","Coffee","Noodles","Pasta","Veg. roll","Sandwich","Waffle","Egg roll","Burger"};
    private static final double[] itemPrices={70.0,30.0,40.0,45.0,45.0,70.0,60.0,100.0,80.0,45.0};

    public static void displayMenu(){
        System.out.println("Menu Item   |   Price");
        for(int i=0; i<menuItems.length;i++){
            System.out.printf("%d. %s   |   %.2f INR%n",(i+1),menuItems[i],itemPrices[i]);
        }
    }

    public static String getItemByIndex(int index){
        return menuItems[index];
    }

    public static double calculateTotalAmount(ArrayList<Integer> index){
        double total=0;
        for(int idx: index){
            total+=itemPrices[idx];
        }
        return total;
    }

    public static void displayBill(ArrayList<Integer> index){
        System.out.println("Item ordered   |   Price");
        for(int idx: index){
            System.out.printf("%s   |   %.2f INR%n",getItemByIndex(idx),itemPrices[idx]);
        }
        System.out.println("---------------------------------------------");
        System.out.printf("Total amount   |   %.2f INR%n",calculateTotalAmount(index));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        displayMenu();
        
        System.out.println("Do you want to order? Enter 'yes' or 'no': ");
        String str=scan.next().trim().toLowerCase();
        while(!str.equals("yes") && !str.equals("no")){
            System.out.print("Please enter either 'yes' or 'no'");
            str=scan.next().trim().toLowerCase();
        }
        boolean userWantsToOrder =str.equals("yes");
        ArrayList<Integer> indexesOfOrderItem = new ArrayList<>();
        while(userWantsToOrder){
            System.out.println("Enter index number of the item you want to order: ");
            try {
                int n= scan.nextInt();
                if(n<=0 || n>menuItems.length){
                    System.out.println("No such index present.");
                    continue;
                }
                indexesOfOrderItem.add(n-1);
                System.out.println("Do you want to order more? Enter 'yes' or 'no': ");
                str=scan.next().trim().toLowerCase();
                while(!str.equals("yes") && !str.equals("no")){
                    System.out.print("Please enter either 'yes' or 'no'");
                    str=scan.next().trim().toLowerCase();
                }
                if(str.equals("no")){
                    userWantsToOrder=false;
                }
            } 
            catch (Exception e) {
                System.out.println("Not a valid index.");
                scan.next();
            }

        }
        if(indexesOfOrderItem.size()==0){
            System.out.println("No items were ordered.");
        }
        else{
            displayBill(indexesOfOrderItem);
        }
    }
}
