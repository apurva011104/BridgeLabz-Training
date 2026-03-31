
public interface InventoryService extends AlertService {

    Product addProduct(String name, int quantity, int reorderLevel);
    void displayAllProducts();
    void reduceStock(Product product, int quantity) throws OutOfStockException;
    void updateProduct(Product product, int quantity);
    void removeProduct(Product product);
    
}
