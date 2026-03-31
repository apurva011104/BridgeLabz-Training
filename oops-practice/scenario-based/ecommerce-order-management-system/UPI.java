public class UPI implements Payment{

    private String upiId;

    public UPI(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (amount <= 0) throw new PaymentFailedException("Invalid amount!");
        System.out.printf("Paid %.2f INR using UPI ID %s",amount, upiId);
    }

    @Override
    public void paymentMethodDetail(){
        System.out.println("Payment method type: UPI, UPI ID: "+upiId);
    }
}
