import java.util.*;

public class ShoppingCart {

    private final HashMap<Product, Integer> priceMap;
    private final LinkedHashMap<Product, Integer> cart;

    public ShoppingCart() {
        priceMap = new HashMap<>();
        cart = new LinkedHashMap<>();
    }

    public void setProductPrice(Product product, int price) {
        if (priceMap.containsKey(product)) {
            System.out.println("Product already exists.");
            return;
        }
        priceMap.put(product, price);
        System.out.println("Price set for " + product);
    }

    public void addToCart(Product product, int quantity) {
        if (!priceMap.containsKey(product)) {
            System.out.println("Add product price first.");
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
        System.out.println(quantity + " of " + product + " added to cart.");
    }

    public void displayCart() {
        System.out.println("Cart:");
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey()+", Qty: "+entry.getValue()+", Price: "+priceMap.get(entry.getKey()));
        }
    }

    public void displaySortedByPrice() {
        TreeMap<Integer, List<Product>> sortedByPrice = new TreeMap<>();
        for (Product product : cart.keySet()) {
            int price = priceMap.get(product);
            sortedByPrice.putIfAbsent(price, new ArrayList<>());
            sortedByPrice.get(price).add(product);
        }

        System.out.println("Products Sorted by Price:");
        for (Map.Entry<Integer, List<Product>> entry : sortedByPrice.entrySet()) {
            for (Product product : entry.getValue()) {
                System.out.println(product + ", Price: " + entry.getKey());
            }
        }
    }

    public void totalBill() {
        int total = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            total += priceMap.get(entry.getKey()) * entry.getValue();
        }
        System.out.println("Total Bill: " + total + " INR");
    }
}
