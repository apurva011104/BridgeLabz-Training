public class RestaurantTableReservationSystem {
    
    public static void reserveTable(Restaurant restaurant, Customer customer, int tableNumber ){
        try {
            restaurant.reserveTable(customer, tableNumber);
        }
        catch (IllegalArgumentException | TableAlreadyReservedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addTable(Restaurant restaurant, int capacity){
        try { 
            restaurant.addTable(capacity);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        
        Restaurant restaurant = new Restaurant();
        Customer customer1 = new Customer("CST123", "Ava");
        Customer customer2 = new Customer("CST245", "Lisa");
        Customer customer3 = new Customer("CST785", "Violet");
        Customer customer4 = new Customer("CST389", "Rose");

        addTable(restaurant, 5 );
        addTable(restaurant, 2 );
        addTable(restaurant, 3 );
        addTable(restaurant, 2 );
        addTable(restaurant, 1 );
        addTable(restaurant, 4 );

        restaurant.showAllTables();

        reserveTable(restaurant, customer4,7);
        reserveTable(restaurant, customer1, 2);
        reserveTable(restaurant, customer2, 4);
        reserveTable(restaurant, customer1, 3);
        reserveTable(restaurant, customer3, 5);
        reserveTable(restaurant, customer4, 2);
        reserveTable(restaurant, customer4, 1);

        restaurant.showAvailableTables();

        restaurant.cancelReservation(customer1);

        restaurant.showAvailableTables();
        
    }
}
