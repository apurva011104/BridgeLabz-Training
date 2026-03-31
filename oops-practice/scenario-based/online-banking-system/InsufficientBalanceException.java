public class InsufficientBalanceException extends Exception {
    @Override
    public String getMessage() {
        return "Insufficient balance for this transaction!";
    }
}