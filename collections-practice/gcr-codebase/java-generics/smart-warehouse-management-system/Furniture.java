public class Furniture extends WarehouseItem {

    public Furniture(String itemID, String itemName) {
        super(itemID, itemName);
    }
    
    @Override
    public String getCategory(){
        return "Furniture";
    }
    
}
