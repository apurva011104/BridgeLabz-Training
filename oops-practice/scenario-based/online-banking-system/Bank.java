import java.util.HashMap;
import java.util.Map;

public class Bank implements BankService {

    private Map<String, Account> accounts = new HashMap<>();

    @Override
    public synchronized void createAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
        System.out.println(account.getAccountHolder() + " - " + account.getAccountNumber() + " created successfully!");
        System.out.println();
    }

    @Override
    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    @Override
    public void transferFunds(String fromAccNum, String toAccNum, double amount) throws InsufficientBalanceException, InvalidAmountException {

        Account fromAccount = accounts.get(fromAccNum);
        Account toAccount = accounts.get(toAccNum);

        if (fromAccount == null || toAccount == null) {
            System.out.println("One of the accounts does not exist.");
            return;
        }

        synchronized (fromAccount) {
            synchronized (toAccount) {
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
                System.out.printf("Transfer of %.2f INR from %s to %s successful!%n",amount, fromAccNum, toAccNum);
            }
        }
    }

    public void transferAmount(Account account1, Account account2, double amount) {
    Thread thread = new Thread(() -> {
        try {
            transferFunds(account1.getAccountNumber(), account2.getAccountNumber(), amount);
        }
        catch (InsufficientBalanceException | InvalidAmountException e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }
    });

    thread.start();

    try {
        thread.join();
    } 
    catch (InterruptedException e) {
        System.out.println(e);
    }

    System.out.println();
}


}
