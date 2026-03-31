public class CurrentAccount extends Account{
    
    private static final double INTEREST_RATE_PERCENTAGE = 4;
    private static final String ACCOUNT_TYPE = "Current Account";

    public CurrentAccount(String accountHolder, double initialBalance) {
        super(accountHolder, initialBalance, ACCOUNT_TYPE);
    }

    @Override
    public double calculateInterest() {
        return (balance * INTEREST_RATE_PERCENTAGE) / 100.0;
    }
}
