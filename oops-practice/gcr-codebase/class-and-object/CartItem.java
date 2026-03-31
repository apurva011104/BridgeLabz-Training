public class CartItem {
    String itemName;
    double price;
    int quantity;

    //Constructoor to create cart item object
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    //Method to add item
    public void addItem(int quantityToAdd){
        quantity+=quantityToAdd;
        System.out.println("Added "+quantityToAdd+" of "+itemName+" to the cart.");
    }

    //Method to remove item
    public void removeItem(int quantityToRemove){
        if(quantityToRemove>quantity){
            System.out.println("Removing quantity is more than the quantity in the cart");
            return;
        }
        quantity-=quantityToRemove;
        System.out.println("Removed "+quantityToRemove+" of "+itemName+" from the cart.");
    }

    //Method to calculate total cost
    private double totalCost(){
        return quantity*price;
    }

    //Method to display total Cost
    public void displayTotalCost(){
        double totalCost = totalCost();
        System.out.printf("Total cost: $%.2f%n",totalCost);
    }

    public void displayItem(){
        System.out.printf("Item: %s, Price: $%.2f, Quantity: %d%n",itemName,price,quantity);
    }
    public static void main(String[] args) {
        CartItem cartItem = new CartItem("Laptop", 999.99, 1);
        cartItem.displayItem();
        cartItem.addItem(2);
        cartItem.removeItem(1);
        cartItem.displayTotalCost();
    }
}
