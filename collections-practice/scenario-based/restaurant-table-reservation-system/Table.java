public class Table {
    
    private final int tableNumber;
    private boolean isAvailable;
    private int tableCapacity;

    public Table(int tableNumber, int tableCapacity) {
        this.tableNumber = tableNumber;
        this.isAvailable = true;
        this.tableCapacity = tableCapacity;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public boolean checkAvailability() {
        return isAvailable;
    }

    public int getTableCapacity() {
        return tableCapacity;
    }

    public void updateAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString(){
        return "[Table Number: "+tableNumber+", Table Capacity: "+tableCapacity+", Available: "+(isAvailable?"Yes":"No")+"]";
    }
}
