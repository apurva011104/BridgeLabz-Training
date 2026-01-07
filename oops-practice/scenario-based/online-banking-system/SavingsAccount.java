public class SavingsAccount extends Account {

    private static final double INTEREST_RATE_PERCENTAGE = 8; 
    private static final String ACCOUNT_TYPE = "Savings Account";

    public SavingsAccount(String accountHolder, double initialBalance) {
        super(accountHolder, initialBalance, ACCOUNT_TYPE);
    }

    @Override
    public double calculateInterest() {
        return (balance * INTEREST_RATE_PERCENTAGE) / 100.0;
    }

}
