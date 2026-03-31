public class EcommerceOrderManagementSystem {
    
    public static void main(String[] args) {
        
        Ecommerce ecommerce = new Ecommerce("Shopping application");
        
        Customer customer1 = ecommerce.addCustomer("Ava");
        customer1.addPaymentMethod(new Card("AVA7845"));
        customer1.addPaymentMethod(new UPI("ava@bankName475"));
        Customer customer2 = ecommerce.addCustomer("Ruby");
        customer2.addPaymentMethod(new Card("RUBY7750"));
        Customer customer3 = ecommerce.addCustomer("Rose");

        Product product1 = ecommerce.addProduct("Black Leather Jacket", "Clothing", 750);
        Product product2 = ecommerce.addProduct("Bru Gold Coffee 500gm","Grocery" ,450);
        Product product3 = ecommerce.addProduct("Denim Jeans","Clothing" , 780 );
        Product product4 = ecommerce.addProduct("Laptop","Electronics" ,55000);
        Product product5 = ecommerce.addProduct("Headphones", "Electronics", 1200);
        Product product6 = ecommerce.addProduct("Black gel pen set 10pcs", "Stationary", 100);

        Order order1 = ecommerce.createOrder(customer1, "Agra");
        Order order2 = ecommerce.createOrder(customer2, "Noida");
        Order order3 = ecommerce.createOrder(customer3, "Pune");

        ecommerce.displayAllCustomers();
        System.out.println();

        ecommerce.displayAllProducts();
        System.out.println();

        ecommerce.addProductToOrder(order1, product1, 1);
        ecommerce.addProductToOrder(order1, product2, 2);
        ecommerce.addProductToOrder(order1, product6, 2);
        ecommerce.addProductToOrder(order1, product1, 1);
        ecommerce.removeProductFromOrder(order1, product1);
        ecommerce.addProductToOrder(order1, product3, 1);
        ecommerce.addProductToOrder(order1, product4, 1);

        ecommerce.processOrder(order2);
        ecommerce.processOrder(order1);
        ecommerce.processOrder(order1);

        ecommerce.addProductToOrder(order1, product1, 1);

        ecommerce.addProductToOrder(order2, product5, 1);
        ecommerce.addProductToOrder(order2, product4, 2);
        ecommerce.addProductToOrder(order2, product6, 2);

        ecommerce.cancelOrder(order2);

        ecommerce.addProductToOrder(order2, product6, 1);

        ecommerce.addProductToOrder(order3,product6, 2);

        ecommerce.displayAllOrdersHistory();
        System.out.println();

        ecommerce.removeCustomer(customer3);

        Order order4 = ecommerce.createOrder(customer1, "Agra");
        ecommerce.addProductToOrder(order4, product1, 1);
        ecommerce.addProductToOrder(order4, product2, 2);
        
        ecommerce.removeProduct(product1);

        ecommerce.displayCustomerOrderHistory(customer1);
        System.out.println();

        ecommerce.displayAllOrdersHistory();
        System.out.println();

        ecommerce.displayAllCustomers();
        System.out.println();

        ecommerce.displayAllProducts();
        System.out.println();

    }

}
