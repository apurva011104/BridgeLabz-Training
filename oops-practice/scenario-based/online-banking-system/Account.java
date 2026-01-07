import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Account {

    private static final Set<String> allAccountNumbers = new HashSet<>();
    private final String accountNumber;
    private String accountHolder;
    protected double balance;
    private List<String> transactionHistory;
    private String accountType;

    public Account(String accountHolder, double balance, String accountType){
        this.accountNumber = generateAccountNumber(accountType);
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.accountType=accountType;
        this.transactionHistory = new ArrayList<>();
    }

    public static boolean isUniqueNumber(String number){
        return !allAccountNumbers.contains(number);
    }

    public static String generateAccountNumber(String accountType){

        String prefix = accountType.substring(0,3).toUpperCase();
        String accNumber;
        do {
            StringBuilder id = new StringBuilder();
            for (int i = 0; i < 12; i++) {
                id.append((char) ('0' + (int)(Math.random() * 10)));
            }
            accNumber = prefix+id.toString();
        } 
        while (!isUniqueNumber(accNumber));

        allAccountNumbers.add(accNumber);
        return accNumber;
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
        System.out.println("Account number: "+accountNumber);
        System.out.printf("Amount withdrawn successfully. Withdrawal amount: %.2f INR %n",amount);
        checkBalance();
        System.out.println();
    }

    public void printTransactionHistory() {
        System.out.println("Transaction history for " + accountNumber + ":");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
        System.out.println();
    }

    public abstract double calculateInterest();
    
}
