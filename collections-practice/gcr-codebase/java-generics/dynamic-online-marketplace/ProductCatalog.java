import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private final List<Product<? extends Category>> catalog;

    public ProductCatalog() {
        this.catalog = new ArrayList<>();
    }

    public boolean isProductPresent(Product<? extends Category> product){
        for(Product<? extends Category> p: catalog){
            if(p.equals(product)){
                return true;
            }
        }
        return false;
    }

    public boolean isProductIDPresent(String id){
        for(Product<? extends Category> p: catalog){
            if(p.getProductID().equals(id)){
                return true;
            }
        }
        return false;
    }

    public void addNewProduct(Product<? extends Category> product) {
        if(isProductPresent(product)){
            System.out.println("Product already present in catalog");
            return;
        }
        if(isProductIDPresent(product.getProductID())){
            System.out.println("Another product for the product id is present in catalog");
            return;
        }
        catalog.add(product);
        System.out.println("Product added successfully");
    }

    public void displayCatalog(){
        for(Product<? extends Category> p: catalog){
            displayProductDetails(p);
        }
    }
    
    public void displayProductDetails(Product<? extends Category> p){
        System.out.printf("Product ID: %s, Product Name: %s, Product Price: %.2f INR, Product Category: %s%n",p.getProductID(), p.getProductName(), p.getPrice(), p.getCategory().getCategoryName());
    }

    public void applyDiscount(Product<? extends Category> product, double percentage){
        DiscountUtils.applyDiscount(product, percentage);
    }

    public void removeProduct(Product<? extends Category> product){
        if(!isProductPresent(product)){
            System.out.println("No such product found in catalog.");
            return;
        }
        catalog.remove(product);
        System.out.println("Product removed from catalog successfully.");
    }
}
