import java.util.ArrayList;

public class ShoppingCart {
    
    class CartItem{
        String itemName;
        double price;
        int quantity;

        public CartItem(String itemName, double price, int quantity) {
            this.itemName = itemName;
            this.price = price;
            this.quantity = quantity;
        }
    }

    ArrayList<CartItem> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<>();
        cartItems.add(new CartItem("Laptop", 999.99, 1));

    }

    public double pricePerItemGenerator(){
        double price = (Math.round(((int)(Math.random()*2000))*100)/100)+0.01;
        return price;
    }

    public void addItemToCart(String itemName , int quantity){
        CartItem cartItem = null;
        for(CartItem item: cartItems){
            if(item.itemName.toLowerCase().equals(itemName.toLowerCase())){
                cartItem=item;
                break;
            }
        }
        if(cartItem==null){
            cartItem = new CartItem(itemName, pricePerItemGenerator() , quantity);
            cartItems.add(cartItem);
        }
        else{
            cartItem.quantity+=quantity;
        }
        System.out.println("Added "+quantity+" of "+cartItem.itemName+" to the cart");
    }
    
    public void removeItemFromCart(String itemName, int quantity){
        CartItem cartItem = null;
        for(CartItem item: cartItems){
            if(item.itemName.toLowerCase().equals(itemName.toLowerCase())){
                cartItem=item;
                break;
            }
        }
        if(cartItem==null){
            System.out.println("No such item exists");
        }
        else{
            cartItem.quantity-=quantity;
            if(cartItem.quantity<=0){
                cartItems.remove(cartItem);
            }
            System.out.println("Removed "+quantity+" of "+itemName+" from the cart");
        }
    }

    public double totalCost(){
        double totalCost=0;
        for(CartItem item: cartItems){
            totalCost += (item.price * item.quantity);
        }
        return totalCost;
    }

    public void displayCart(){
        for(CartItem item: cartItems){
            System.out.printf("Item: %s, Price: $%.2f, Quantity: %d%n",item.itemName,item.price,item.quantity);
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.displayCart();
        cart.addItemToCart("Laptop", 2);
        cart.removeItemFromCart("Laptop", 1);
        double totalCost = cart.totalCost();
        System.out.printf("Total cost: $%.2f%n",totalCost);
    }
}
