import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Item{

    private final  String itemId;
    private String name;
    private int quantity;
    private double price;

    public Item(String itemId, String name, int quantity, double price) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayItem() {
        System.out.printf("Item ID: %s, Name: %s, Quantity: %d, Price: %.2f INR%n",itemId, name, quantity, price);
    }

}

class ItemNode{

    private Item item;
    private ItemNode next;

    public ItemNode(Item item) {
        this.item = item;
    }

    
    public Item getItem() {
        return item;
    }

    public ItemNode getNext() {
        return next;
    }

    public void setNext(ItemNode next) {
        this.next = next;
    }

}

public class InventoryManagementSystem {

    private Set<String> allItemIDs;

    public InventoryManagementSystem() {
        this.allItemIDs = new HashSet<>();
    }

    ItemNode itemHead;
    ItemNode itemTail;
    
    private boolean itemAlreadyExists(String itemId){
        return allItemIDs.contains(itemId);
    }

    //Method to find size
    public int size(){
        int size=0;
        ItemNode current = itemHead;
        while(current!=null){
            size++;
            current=current.getNext();
        }
        return size;
    }

    /*----------------------------CREATE OPERATIONS-----------------------------*/
    
    public void addItemAtBeginning(String itemId, String name, int quantity, double price) {
        if(price<=0){
            System.out.println("Invalid price");
            return;
        }
        if(quantity<=0){
            System.out.println("Invalid quantity");
            return;
        }
        if (itemAlreadyExists(itemId)) {
            System.out.println("Item ID already exists");
            return;
        }

        Item item = new Item(itemId, name, quantity, price);
        ItemNode itemNode = new ItemNode(item);

        if (itemHead == null) {
            itemHead = itemNode;
            itemTail = itemNode;
        } else {
            itemNode.setNext(itemHead);
            itemHead = itemNode;
        }
        allItemIDs.add(itemId);
        System.out.println("Item added successfully");
    }

    public void addItemAtEnd(String itemId, String name, int quantity, double price) {
        if(price<=0){
            System.out.println("Invalid price");
            return;
        }
        if(quantity<=0){
            System.out.println("Invalid quantity");
            return;
        }
        if (itemAlreadyExists(itemId)) {
            System.out.println("Item ID already exists");
            return;
        }

        Item item = new Item(itemId, name, quantity, price);
        ItemNode itemNode = new ItemNode(item);

        if (itemHead == null) {
            itemHead = itemNode;
            itemTail = itemNode;
        } else {
            itemTail.setNext(itemNode);
            itemTail = itemNode;
        }
        allItemIDs.add(itemId);
        System.out.println("Item added successfully");
    }
    
    public void addItem(String itemId, String name, int quantity, double price, int position) {
        if(price<=0){
            System.out.println("Invalid price");
            return;
        }
        if(quantity<=0){
            System.out.println("Invalid quantity");
            return;
        }
        
        if (position < 0 || position > size()) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 0) {
            addItemAtBeginning(itemId, name, quantity, price);
        } 
        else if (position == size()) {
            addItemAtEnd(itemId, name, quantity, price);
        } 
        else {
            
            Item item = new Item(itemId, name, quantity, price);
            ItemNode itemNode = new ItemNode(item);

            ItemNode current = itemHead;

            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }

            itemNode.setNext(current.getNext());
            current.setNext(itemNode);
            allItemIDs.add(itemId);
            System.out.println("Item added successfully");
        }
    }

    /*----------------------------READ OPERATIONS-----------------------------*/

    //Method to search an item by item id
    public void searchItemById(String itemId){
        ItemNode current = itemHead;

        while(current!=null){
            if(current.getItem().getItemId().equals(itemId)){
                break;
            }
            current = current.getNext();
        }

        if(current==null){
            System.out.println("No such item found");
        }
        else{
            System.out.println("Item found: ");
            current.getItem().displayItem();
        }
    }

    //Method to search an item by item name
    public void searchItemByName(String name){
        ItemNode current = itemHead;

        ArrayList<ItemNode> foundItems = new ArrayList<>();
        while(current!=null){
            if(current.getItem().getName().equalsIgnoreCase(name)){
                foundItems.add(current);
            }
            current = current.getNext();
        }

        if(foundItems.size()==0){
            System.out.println("No such item found");
        }
        else{
            System.out.println("Item(s) found:");
            for(ItemNode item: foundItems){
                item.getItem().displayItem();
            }
        }
    }

    public void displayAllItems(){
        if(itemHead == null){
            System.out.println("Inventory is empty");
            return;
        }
        ItemNode current = itemHead;

        System.out.println("Inventory: ");
        while(current!=null){
            current.getItem().displayItem();
            current = current.getNext();
        }
    }

    private double calculateTotal(){
        double total =0;

        ItemNode current = itemHead;

        System.out.println("Inventory: ");
        while(current!=null){
            total += current.getItem().getPrice() * current.getItem().getQuantity();
            current = current.getNext();
        }
        
        return total;
    }

    public void displayTotalPrice(){
        double total = calculateTotal();
        System.out.printf("Inventory's total price: %.2f INR%n",total);
    }

    /*----------------------------UPDATE OPERATIONS-----------------------------*/
    public void updateQuantity(String itemId, int newQuantity){
        if(!itemAlreadyExists(itemId)){
            System.out.println("No such item exists");
            return;
        }
        ItemNode current = itemHead;

        while(current!=null){
            if(current.getItem().getItemId().equals(itemId)){
                break;
            }
            current = current.getNext();
        }

        current.getItem().setQuantity(newQuantity);
        System.out.println("Quantity updated successfully");
    }

    /*----------------------------DELETE OPERATIONS-----------------------------*/
    public void removeItem(String itemID) {

        if (!itemAlreadyExists(itemID)) {
            System.out.println("No such item found in the inventory.");
            return;
        }

        ItemNode temp;

        if (itemHead.getItem().getItemId().equals(itemID)) {
            temp = itemHead;
            itemHead = itemHead.getNext();
            if (itemHead == null) {
                itemTail = null;
            }
        }
        else {
            ItemNode current = itemHead;

            while (current.getNext() != null) {
                if (current.getNext().getItem().getItemId().equals(itemID)) {
                    temp = current.getNext();
                    if (temp == itemTail) {
                        itemTail = current;
                    }

                    current.setNext(temp.getNext());
                    break;
                }
                current = current.getNext();
            }
        }

        allItemIDs.remove(itemID);
        System.out.println("Item deleted successfully");
    }

    /*--------------------------SORTING-----------------------------------------*/
    public void sortByName(boolean ascending) {
        itemHead = mergeSort(itemHead, ascending, true);
        System.out.println("Sorted by Item Name");
    }

    public void sortByPrice(boolean ascending) {
        itemHead = mergeSort(itemHead, ascending, false);
        System.out.println("Sorted by Price");
    }

    private ItemNode mergeSort(ItemNode head, boolean ascending, boolean sortByName) {
        if (head == null || head.getNext() == null)
            return head;

        ItemNode middle = getMiddle(head);
        ItemNode nextOfMiddle = middle.getNext();
        middle.setNext(null);

        ItemNode left = mergeSort(head, ascending, sortByName);
        ItemNode right = mergeSort(nextOfMiddle, ascending, sortByName);

        return sortedMerge(left, right, ascending, sortByName);
    }

    private ItemNode getMiddle(ItemNode head) {
        ItemNode slow = head, fast = head.getNext();
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    private ItemNode sortedMerge(ItemNode a, ItemNode b, boolean ascending, boolean sortByName) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;

        if (sortByName) {
            int cmp = a.getItem().getName().compareToIgnoreCase(b.getItem().getName());
            condition = ascending ? cmp <= 0 : cmp > 0;
        } else {
            condition = ascending ? a.getItem().getPrice() <= b.getItem().getPrice(): a.getItem().getPrice() > b.getItem().getPrice();
        }

        if (condition) {
            a.setNext(sortedMerge(a.getNext(), b, ascending, sortByName));
            return a;
        } else {
            b.setNext(sortedMerge(a, b.getNext(), ascending, sortByName));
            return b;
        }
    }

    //main method for testing
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        ims.addItemAtEnd("I64525","Pen",10,15.5);
        ims.addItemAtEnd("I24512","Notebook",5,50.0);
        ims.addItemAtBeginning("I05103","Eraser",20,5.0);

        ims.displayAllItems();
        ims.sortByPrice(true);
        ims.displayAllItems();
        ims.displayTotalPrice();

        ims.updateQuantity("I05103", 10);
        ims.searchItemByName("Pen");

        ims.removeItem("I24512");
        ims.displayAllItems();
    }
}


