package junit;

public class BankAccount {
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public void deposit(double amount){
        if(amount<=0){
            throw new IllegalArgumentException("Invalid deposit amount!");
        }
        this.balance += amount;
        System.out.printf("Amount %.2f INR deposited to bank account %s successfully. Current balance: %.2f INR%n",amount,accountNumber,balance);
    }

    public void withdraw(double amount) throws InsufficientBalanceException{
        if(amount<=0){
            throw new IllegalArgumentException("Invalid withdrawal amount!");
        }
        if(amount>balance){
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        this.balance -= amount;
        System.out.printf("Amount %.2f INR withdraw from bank account %s successfully. Current balance: %.2f INR%n",amount,accountNumber,balance);
    }
    
}


class InsufficientBalanceException extends Exception{

    public InsufficientBalanceException(String message){
        super(message);
    }
}