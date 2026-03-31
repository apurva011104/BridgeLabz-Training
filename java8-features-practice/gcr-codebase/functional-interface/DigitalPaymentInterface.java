public class DigitalPaymentInterface {

    public static void main(String[] args) {

        Payment wallet = new Wallet();
        Payment upi = new UPI();
        Payment creditCatd =new CreditCard();


        Payment[] payments = {wallet, upi, creditCatd};

        for(Payment payment: payments){
            payment.pay();
        }

    }
}

interface Payment{
    void pay();
}

class UPI implements Payment{
    public void pay(){
        System.out.println("Paying using UPI.....");
    }
}

class CreditCard implements Payment{
    public void pay(){
        System.out.println("Paying using Credit card.....");
    }
}

class Wallet implements Payment{
    public void pay(){
        System.out.println("Paying using Wallet.....");
    }
}