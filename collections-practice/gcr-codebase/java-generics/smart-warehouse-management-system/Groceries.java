public class Groceries extends WarehouseItem {

    public Groceries(String itemID, String itemName) {
        super(itemID, itemName);
    }
    
    @Override
    public String getCategory(){
        return "Grocery";
    }
    
}
