public class PaymentGatewayIntegrtion {

    public static void main(String[] args) {
        PaymentProcessor processor1 = new GoogleProvider();
        PaymentProcessor processor2 = new AmazonProvider();

        processor1.refund(15);
        processor2.refund(15);
    }
    
}

interface PaymentProcessor{
    default boolean refund(double amount){
        if(amount<=0){
            throw new IllegalArgumentException("Invalid amount to refund");
        }
        try {
            System.out.println("Amount refunded by successfully");
            return true;
        }
        catch (Exception e) {
            System.out.println("Refund failed");
            return false;
        }
    }
}

class GoogleProvider implements PaymentProcessor{

    private static final String providerName = "Google";

    @Override
    public String toString() {
        return "Provider: "+providerName;
    }
    
}

class AmazonProvider implements PaymentProcessor{
    private static final String providerName = "Amazon";

    @Override
    public String toString() {
        return "Provider: "+providerName;
    }

    @Override
    public boolean refund(double amount){
        if(amount<=0){
            throw new IllegalArgumentException("Invalid amount to refund");
        }
        try {
            System.out.println("Amount refunded by "+ providerName +" provider successfully");
            return true;
        }
        catch (Exception e) {
            System.out.println("Refund failed");
            return false;
        }
    }
}