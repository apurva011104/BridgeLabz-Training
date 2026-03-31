import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage <T extends WarehouseItem> {
    
    private final List<T> itemsRecord;
    private final HashMap<T,Integer> itemStock;
    private final int MAXIMUM_QUANTITY;

    public Storage(int maximumQuantityOfEachItem) {
        this.MAXIMUM_QUANTITY = maximumQuantityOfEachItem;
        this.itemsRecord = new ArrayList<>();
        this.itemStock = new HashMap<>();
    }

    private boolean checkIfIDExists(String id){
        for(T item: itemsRecord){
            if(item.getItemID().equals(id)){
                return true;
            }
        }
        return false;
    }

    /*-------------------------CREATE OPERATIONS---------------------*/
    public void addNewItem(T item, int quantity){
        if(itemsRecord.contains(item)){
            System.out.println("Item is already present in the warehouse");
            return;
        }
        if(checkIfIDExists(item.getItemID())){
            System.out.println("Item with this ID already exists");
            return;
        }
        itemsRecord.add(item);
        if(quantity>MAXIMUM_QUANTITY){
            itemStock.put(item,MAXIMUM_QUANTITY);
            System.out.println("Maximum quantity reached. Cannot add anymore quantity.");
        }
        else{
            itemStock.put(item,quantity);
        }
        System.out.println("New item added successfully.");
    }

    /*-------------------------READ OPERATIONS-----------------------*/
    public void displayItemDetails(){
        WarehouseUtils.displayItems(itemsRecord);
    }

    /*-------------------------UPDATE OPERATIONS---------------------*/
    public void addStock(T item, int quantityToAdd){
        if(quantityToAdd<=0){
            System.out.println("Invalid quantity to add");
            return;
        }
        if(!itemStock.containsKey(item)){
            System.out.println("Item not found in warehouse.");
            return;
        }
        if(itemStock.get(item)==MAXIMUM_QUANTITY){
            System.out.println("Maximum quantity reached. Cannot add more stock.");
            return;
        }
        int newStock = itemStock.get(item)+quantityToAdd;
        if(newStock>MAXIMUM_QUANTITY){
            itemStock.replace(item, MAXIMUM_QUANTITY);
            System.out.println("Maximum quantity reached. Cannot add anymore items.");
            
        }
        else{
            itemStock.replace(item, newStock);
        }
        System.out.println("Item stock updated successfully");
    }
    
    public void removeStock(T item, int quantityToRemove){
        if(quantityToRemove<=0){
            System.out.println("Invalid quantity to add");
            return;
        }
        if(!itemStock.containsKey(item)){
            System.out.println("Item not found in warehouse.");
            return;
        }
        if(itemStock.get(item)<=0){
            System.out.println("No item stock left in the warehouse.");
            return;
        }
        int newStock = itemStock.get(item) - quantityToRemove;
        if(newStock<0){
            itemStock.replace(item, 0);
            System.out.println("No item stock left in the warehouse.");
        }
        else{
            itemStock.replace(item, newStock);
        }
        System.out.println("Item stock updated successfully");
    }

    /*-------------------------DELETE OPERATIONS---------------------*/
    public void removeItem(T item){
        if(!itemsRecord.contains(item)){
            System.out.println("Item not found in the warehouse");
            return;
        }
        itemsRecord.remove(item);
        itemStock.remove(item);
        System.out.println("Item removed successfully");
    }
}
