package test_case;

public class Program {

    private final String accountNumber;
    private double balance;

    public Program(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        if(amount<0){
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
        balance += amount;
        System.out.println("Amount deposited successfully. Current balance: "+balance);
    }

    public void withdraw(double amount){
        if(amount<0){
            throw new IllegalArgumentException("Withdraw amount cannot be negative");
        }
        if(amount>balance){
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
        System.out.println("Amount withdraw successfully. Current balance: "+balance);
    }
    
}
