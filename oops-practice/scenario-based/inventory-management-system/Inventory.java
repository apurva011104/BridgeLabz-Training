import java.util.ArrayList;
import java.util.List;

public class Inventory implements InventoryService {

    private List<Product> productsRecord;

    public Inventory() {
        this.productsRecord = new ArrayList<>();
    }

    @Override
    public void checkLowStock(Product product) {
        if (product.getQuantity() <= product.getReorderLevel()) {
            System.out.println("Low stock for product.");
        }
    }

    /*--------------------------ID GENERATION-----------------------------*/
    private boolean isProductIDPresent(String id){
        for(Product product: productsRecord){
            if(product.getProductId().equals(id)){
                return true;
            }
        }
        return false;
    }

    private String generateProductId(){
        String id;
        do { 
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<12;i++){
                int charType=(int)(Math.random()*3);

                switch (charType){
                    case 0:
                        sb.append((char)((int)(Math.random()*26)+'a'));
                        break;
                    case 1:
                        sb.append((char)((int)(Math.random()*26)+'A'));
                        break;
                    case 2:
                        sb.append((char)((int)(Math.random()*10)+'0'));
                        break;
                }
            }
            id = "PROD"+sb.toString();
        }
        while (isProductIDPresent(id));
        return id;
    }

    /*-------------------------------CREATE OPERATIONS---------------------*/
    @Override
    public Product addProduct(String name, int quantity, int reorderLevel) {
        Product product = new Product(generateProductId(), name, quantity, reorderLevel);
        productsRecord.add(product);
        return product;
    }

    /*---------------------------------READ OPERATIONS-------------------------------*/
    @Override
    public void displayAllProducts() {
        System.out.println("---------------------------------");
        System.out.println("Inventory Products:");
        for (Product p : productsRecord) {
            p.displayProductDetails();
            System.out.println();
        }
        System.out.println("---------------------------------");
    }

    /*---------------------------UPDATE OPERATIONS----------------------------*/
    @Override
    public void updateProduct(Product product, int quantity) {
        if (!productsRecord.contains(product)) {
            System.out.println("Product not found in inventory");
            return;
        }
        product.updateQuantity(quantity);
        checkLowStock(product);
    }

    @Override
    public void reduceStock(Product product, int quantity) throws OutOfStockException {
        if (!productsRecord.contains(product)) {
            System.out.println("Product not found in inventory");
            return;
        }
        if (product.getQuantity() < quantity) {
            throw new OutOfStockException();
        }
        product.updateQuantity(product.getQuantity() - quantity);
        checkLowStock(product);
    }

    /*----------------------------------DELETE OPERATIONS--------------------------*/
    @Override
    public void removeProduct(Product product) {
        if (!productsRecord.contains(product)) {
            System.out.println("Product not found in inventory");
            return;
        }
        productsRecord.remove(product);
        System.out.println("Product removed successfully");
    }
}
