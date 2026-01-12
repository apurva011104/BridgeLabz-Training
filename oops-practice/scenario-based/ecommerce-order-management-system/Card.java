public class Card implements Payment{

    private String cardNumber;

    public Card( String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (amount <= 0)        throw new PaymentFailedException("Invalid amount!");
        System.out.printf("Paid %.2f INR using Card %s",amount, cardNumber);
    }

     @Override
    public void paymentMethodDetail(){
        System.out.println("Payment method type: Card, Card Number: "+cardNumber);
    }
}
