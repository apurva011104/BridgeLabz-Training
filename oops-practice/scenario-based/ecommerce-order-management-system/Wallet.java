public class Wallet implements Payment {

    private String walletName;
    
    public Wallet(String walletName ) {
        this.walletName = walletName;
    }


    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (amount <= 0) throw new PaymentFailedException("Invalid amount!");
        System.out.printf("Paid %.2f INR using Wallet %s",amount, walletName);
    }

     @Override
    public void paymentMethodDetail(){
        System.out.println("Payment method type: Wallet, Wallet Name: "+walletName);
    }

}
