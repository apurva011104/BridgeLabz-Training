public class PayAmountForCourse {
    public static void main(String[] args) {
        double fee=125000.0;
        double discountPercentage=10.0;
        double discount= (discountPercentage * fee) / 100.0;
        double amountToPay= fee - discount;
        System.out.println("The discount amount is " + discount + " and the final discounted fee is INR " + amountToPay);
    }
}
