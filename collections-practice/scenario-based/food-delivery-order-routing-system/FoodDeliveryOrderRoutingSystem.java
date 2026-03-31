public class FoodDeliveryOrderRoutingSystem {
    public static void main(String[] args) {
        DeliveryService service = new DeliveryService();

        service.placeOrder("Ava", 3.08);
        service.placeOrder("Alice", 0.85);
        Order order1 = service.placeOrder("Alexa", 2.53);
        service.placeOrder("Abby", 4.84);
        Order order2 = service.placeOrder("Avery", 2.36);
        service.placeOrder("Amelia", 1.68);

        service.cancelOrder(order1);

        service.addAgent("Chloe", 1.05);
        service.addAgent("Annie", 2.03);
        service.addAgent("Bella", 0.85);
        service.addAgent("Violet", 1.58);

        try {
            service.assignOrders();
        } catch (NoAgentAvailableException e) {
            System.out.println(e.getMessage());
        }

        service.displayActiveDeliveries();

        service.cancelOrder(order2);

        try {
            service.assignOrders();
        } catch (NoAgentAvailableException e) {
            System.out.println(e.getMessage());
        }

        service.displayActiveDeliveries();


    }
}
