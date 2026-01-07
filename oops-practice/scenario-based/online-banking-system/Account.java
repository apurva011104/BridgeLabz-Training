import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private final String accountNumber;
    private String accountHolder;
    protected double balance;
    private List<String> transactionHistory;

    public Account(String accountNumber, String accountHolder, double balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void checkBalance(){
        System.out.printf("Current balance: %.2f INR%n",balance);
    }

    public synchronized void deposit(double amount) throws InvalidAmountException{
        if(amount<=0){
            throw new InvalidAmountException();
        }
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
        System.out.printf("Amount deposited successfully. Deposited amount: %.2f INR %n",amount);
        checkBalance();
        System.out.println();
    }
    
    public synchronized void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if(amount<=0){
            throw new InvalidAmountException();
        }
        if (balance < amount) {
            throw new InsufficientBalanceException();
        }
        balance -= amount;
        transactionHistory.add("Withdrawn: " + amount);
        System.out.printf("Amount withdrawn successfully. Withdrawal amount: %.2f INR %n",amount);
        checkBalance();
        System.out.println();
    }

    public void printTransactionHistory() {
        System.out.println("Transaction history for " + accountNumber + ":");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }

    public abstract double calculateInterest();
    
}
