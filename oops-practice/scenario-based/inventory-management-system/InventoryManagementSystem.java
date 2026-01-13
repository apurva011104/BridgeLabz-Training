public class InventoryManagementSystem {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        Product p1 = inventory.addProduct("Laptop", 10, 3);
        Product p2 = inventory.addProduct("Sketch Pad", 20, 5);

        inventory.displayAllProducts();

        try {
            inventory.reduceStock(p1, 8);
            inventory.reduceStock(p1, 2);
        } 
        catch (OutOfStockException e) {
            System.out.println(e);
        }

        inventory.displayAllProducts();

        inventory.removeProduct(p2);
        inventory.displayAllProducts();
    }
}
