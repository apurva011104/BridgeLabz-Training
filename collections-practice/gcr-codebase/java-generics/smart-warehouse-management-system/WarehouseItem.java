public abstract class WarehouseItem {
    
    private final String itemID;
    private String itemName;

    public WarehouseItem(String itemID, String itemName) {
        this.itemID = itemID;
        this.itemName = itemName;
    }

    public String getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public abstract String getCategory();

    public void displayDetails(){
        System.out.printf("Item category: %s, Item ID: %s, Item name: %s%n",getCategory(),itemID,itemName);
    }
    
}
