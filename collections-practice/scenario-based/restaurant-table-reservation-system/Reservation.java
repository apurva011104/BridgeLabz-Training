public class Reservation {
    
    private final String reservationID;
    private final Table table;
    private final Customer customer;
    private boolean isCancelled;

    public Reservation(String reservationID, Table table, Customer customer) {
        this.reservationID = reservationID;
        this.table = table;
        this.customer = customer;
        this.isCancelled = false;
    }

    public String getReservationID() {
        return reservationID;
    }

    public Table getTable() {
        return table;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean cancellationStatus() {
        return isCancelled;
    }

    public void updateCancellationStatus(boolean isCancelled) {
        if(this.isCancelled){
            return;
        }
        this.isCancelled = isCancelled;
    }
    
}
