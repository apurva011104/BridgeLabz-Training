public interface BankService {
    void createAccount(Account account);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount) throws InsufficientBalanceException, InvalidAmountException;
    Account getAccount(String accountNumber);
}
