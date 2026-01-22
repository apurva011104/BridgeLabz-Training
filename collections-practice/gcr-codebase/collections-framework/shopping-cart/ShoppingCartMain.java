public class ShoppingCartMain {
    public static void main(String[] args) {
        Product product1 = new Product("P1234","Jeans");
        Product product2 = new Product("P5114","Laptop");
        Product product3 = new Product("P1874","Phone");
        Product product4 = new Product("P5843","Shoes");
        Product product5 = new Product("P9236","Watch");

        ShoppingCart cart = new ShoppingCart();

        cart.setProductPrice(product1, 750);
        cart.setProductPrice(product2, 50000);
        cart.setProductPrice(product3, 20000);
        cart.setProductPrice(product4, 900);
        cart.setProductPrice(product5, 450);

        cart.addToCart(product1, 1);
        cart.addToCart(product3, 1);
        cart.addToCart(product5, 1);
        cart.addToCart(product1, 2);
        
        cart.displaySortedByPrice();
        System.out.println();
        cart.displayCart();
        System.out.println();
        cart.totalBill();
    }

}
