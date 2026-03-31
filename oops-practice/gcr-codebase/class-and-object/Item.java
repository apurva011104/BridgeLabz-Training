public class Item {

    String itemCode;
    double itemPrice;
    String itemName;

    //Constructor to create item objects
    Item(String itemCode, double itemPrice, String itemName) {
        this.itemCode = itemCode;
        this.itemPrice = itemPrice;
        this.itemName = itemName; 
    }

    //Method to display item details
    public void displayDetails(){
        System.out.println("Item Code: "+itemCode);
        System.out.printf("Item Price: %.2f %n",itemPrice);
        System.out.println("Item Name: "+itemName);
        System.out.println("---------------------------------------------------");
    }

    public static void main(String[] args) {

        Item item1 = new Item("01AA",500,"Water Bottle");
        Item item2 = new Item("01BB",700,"Rice");
        Item item3 = new Item("02AA",400,"Blackboard");
        
        item1.displayDetails();
        item2.displayDetails();
        item3.displayDetails();
    }
  
}
