public class InvalidAmountException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid amount for this transaction!";
    }
}
