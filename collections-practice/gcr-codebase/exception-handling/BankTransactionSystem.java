import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class BankTransactionSystem {
    
    private Map<String, Double> accountsRecord;

    public BankTransactionSystem() {
        this.accountsRecord = new HashMap<>();
    }

    public void addAccount(String accountNumber, double balance){
        if(accountsRecord.containsKey(accountNumber)){
            System.out.println("Account already exists in the bank.");
            return;
        }
        if(balance<0){
            throw new IllegalArgumentException("Invalid amount!");
        }
        accountsRecord.put(accountNumber, balance);
        System.out.println("Account added successfully.");
    }

    public void deposit(String accountNumber, double depositAmount){
        if(!accountsRecord.containsKey(accountNumber)){
            System.out.println("Account number is not present in the records");
            return;
        }
        if(depositAmount<=0){
            throw new IllegalArgumentException("Invalid amount!");
        }
        double balance = accountsRecord.get(accountNumber);
        accountsRecord.replace(accountNumber, balance + depositAmount);
        System.out.println("Deposit successful, new balance: "+(balance+depositAmount));
    }

    public void withdraw(String accountNumber, double withdrawalAmount) throws InsufficientBalanceException{
        if(!accountsRecord.containsKey(accountNumber)){
            System.out.println("Account number is not present in the records");
            return;
        }
        if(withdrawalAmount<=0){
            throw new IllegalArgumentException("Invalid amount!");
        }
        double balance = accountsRecord.get(accountNumber);
        if(balance<withdrawalAmount){
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        accountsRecord.replace(accountNumber, balance - withdrawalAmount);
        System.out.println("Withdrawal successful, new balance: "+(balance-withdrawalAmount));
    }

    public static void main(String[] args) {
        
        Scanner scanner =  new Scanner(System.in);

        String accountNumber = "ACC1234";
        double currentBalance = 5000;

        BankTransactionSystem bank = new BankTransactionSystem();
        bank.addAccount(accountNumber, currentBalance);

        try {
            System.out.print("Enter withdrawal amount: ");
            double withdrawalAmount = scanner.nextDouble();

            bank.withdraw(accountNumber, withdrawalAmount);
        } 
        catch (InputMismatchException e) {
            System.out.println("Invalid amount");
        }
        catch(IllegalArgumentException | InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }
    }
    
}

class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message){
        super(message);
    }

}
