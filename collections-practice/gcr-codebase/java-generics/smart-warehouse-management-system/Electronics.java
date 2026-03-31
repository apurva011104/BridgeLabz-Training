public class Electronics extends WarehouseItem {

    public Electronics(String itemID, String itemName) {
        super(itemID, itemName);
    }
    
    @Override
    public String getCategory(){
        return "Electronics";
    }
    
}
