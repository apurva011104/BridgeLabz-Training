public class SmartWarehouseSystem{
    public static void main(String[] args) {

        WarehouseItem witem1 = new Furniture("FNR123","Couch");
        WarehouseItem witem2 = new Electronics("ELE782","Television");
        WarehouseItem witem3 = new Groceries("GRC436", "Soap");
        Furniture fitem1 = new Furniture("FNR831","Chair");
        Furniture fitem2 = new Furniture("FNR141","Table");
        Electronics eitem1 = new Electronics("ELE647","Air Conditioner");
        Electronics eitem2 = new Electronics("ELE123","Laptop");
        Groceries gitem1 = new Groceries("GRC123","Detergent");
        Groceries gitem2 = new Groceries("GRC123","Ketchup");

        Storage<WarehouseItem> storage = new Storage<>(100);
        Storage<Electronics> electronicsStorage = new Storage<>(25);
        Storage<Furniture> furnitureStorage = new Storage<>(50);
        Storage<Groceries> groceryStorage = new Storage<>(100);

        storage.addNewItem(witem1, 12);
        storage.addNewItem(fitem2, 6);
        storage.addNewItem(witem3, 75);
        storage.addNewItem(witem2, 35);
        storage.addNewItem(gitem1, 64);
        storage.addNewItem(eitem1, 24);

        furnitureStorage.addNewItem(fitem2,6);
        furnitureStorage.addNewItem(fitem1,24);
    
        electronicsStorage.addNewItem(eitem1, 36);
        electronicsStorage.addNewItem(eitem2, 25);

        groceryStorage.addNewItem(gitem1, 50);
        groceryStorage.addNewItem(gitem1, 55);
        groceryStorage.addNewItem(gitem2, 45);

        furnitureStorage.addStock(fitem2, 10);
        furnitureStorage.addStock(fitem1, 40);

        groceryStorage.removeStock(gitem2, 15);
        groceryStorage.removeStock(gitem1, 15);
        electronicsStorage.removeStock(eitem2, 15);

        storage.removeItem(witem3);

        System.out.println();
        storage.displayItemDetails();
        System.out.println();
        electronicsStorage.displayItemDetails();
        System.out.println();
        furnitureStorage.displayItemDetails();
        System.out.println();
        groceryStorage.displayItemDetails();
    }
}