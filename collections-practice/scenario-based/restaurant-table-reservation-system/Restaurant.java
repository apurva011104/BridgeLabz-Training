import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {
    
    private final Map<Integer, Table> tables;
    private final List<Reservation> reservationsRecord;

    public Restaurant() {
        this.tables = new LinkedHashMap<>();
        this.reservationsRecord = new ArrayList<>();
    }
    
    public void addTable(int capacity){

        if(capacity<=0 || capacity>10){
            throw new IllegalArgumentException("Invalid table capacity.");
        }

        Table table = new Table(tables.size()+1, capacity);
        tables.put(table.getTableNumber(), table);
        System.out.println("Table added to restaurant successfully.");
        
    }

    public void showAllTables(){
        System.out.println("----------------------All Tables------------------");
        if(tables.isEmpty()){
            System.out.println("Restaurant is empty.");
            return;
        }
        for(Map.Entry<Integer, Table> table: tables.entrySet()){
            System.out.println(table.getValue());
        }
    }

    public void showAvailableTables(){
        List<Table> availableTables = new ArrayList<>();
        for(Map.Entry<Integer, Table> entry: tables.entrySet()){
            Table table = entry.getValue();
            if(table.checkAvailability()){
                availableTables.add(table);
            }
        }

        if(availableTables.isEmpty()){
            System.out.println("No tables available");
        }
        else{
            System.out.println("--------------------Available Tables-------------------");
            for(Table table: availableTables){
                System.out.println(table);
            }
        }
    }

    public void reserveTable(Customer customer, int tableNumber) throws TableAlreadyReservedException{
        if(!tables.containsKey(tableNumber)){
            throw new IllegalArgumentException("No table with such table number foundd in the record.");
        }
        if(!tables.get(tableNumber).checkAvailability()){
            throw new TableAlreadyReservedException("Table not available.");
        }

        Table table = tables.get(tableNumber);
        table.updateAvailability(false);
        
        String reservationID = "RSER"+(reservationsRecord.size()+1); 

        Reservation reservation = new Reservation( reservationID, table, customer);
        reservationsRecord.add(reservation);
        
        System.out.println("Table number: "+tableNumber+" is reserved successfully by "+customer.getCustomerName());
    }

    public void cancelReservation(Customer customer){
        List<Reservation> customerReservations = new ArrayList<>();

        for(Reservation reservation: reservationsRecord){
            if(reservation.getCustomer().equals(customer)){
                customerReservations.add(reservation);
            }
        }

        if(customerReservations.isEmpty()){
            System.out.println("Customer don't have any reservation");
        }
        else{
            for(Reservation reservation: customerReservations){
                Table table = reservation.getTable();
                if(reservation.cancellationStatus()){
                    System.out.println("Reservation for table "+table.getTableNumber()+" has been cancelled already.");
                }
                else{
                    reservation.updateCancellationStatus(true);
                    table.updateAvailability(true);
                    System.out.println("Customer "+customer.getCustomerName()+" cancelled the reservation for table number "+table.getTableNumber()+" successfully.");
                }
            }
        }

    }
    
}
