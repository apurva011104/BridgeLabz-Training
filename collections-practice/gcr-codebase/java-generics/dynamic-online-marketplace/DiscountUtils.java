public class DiscountUtils {

    public static <T extends Product<? extends Category>> void applyDiscount(T product, double percentage) {

        if (percentage <= 0 || percentage > 75) {
            System.out.println("Invalid discount percentage");
            return;
        }

        double discount = (product.getPrice() * percentage)/100;
        double discountedPrice = product.getPrice() - discount;

        try{
            product.setPrice(discountedPrice);
            System.out.println("Discount applied successfully");
        }
        catch(PriceNotInRangeException e){
            System.out.println("Discount cannot be applied.");
        }
        
    }
}
