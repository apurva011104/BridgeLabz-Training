public class SavingsAccount extends Account {

    private static final double INTEREST_RATE_PERCENTAGE = 8; 

    public SavingsAccount(String accountNumber, String accountHolder, double initialBalance) {
        super(accountNumber, accountHolder, initialBalance);
    }

    @Override
    public double calculateInterest() {
        return (balance * INTEREST_RATE_PERCENTAGE) / 100.0;
    }

}
