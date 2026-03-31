public class BankAccount {

    public String accountNumber;        // public variable
    protected String accountHolder;     // protected variable
    private double balance;             // private variable

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public method to access balance
    public double getBalance() {
        return balance;
    }

    // Public method to modify balance (deposit and withdraw)
    public void depositAmount(double amount) {
        balance += amount;
        System.out.println(accountHolder+" deposited amount successfully");
    }
    public void withdrawAmount(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(accountHolder+" withdrawed amount successful!");
        }
        else{
            System.out.println("Withdrawl not possible!");
        }
    }

    // Method to display account details
    public void displayAccount() {
        System.out.println("----------------------------------");
        System.out.println("Bank Account details: ");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.printf("Current balance: %.2f%n", balance);
        System.out.println("----------------------------------");
    }

}


class SavingsAccount extends BankAccount {

    private static final String accountType = "Savings account"; 

    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void displaySavingsAccount() {
        System.out.println("----------------------------------");
        System.out.println("Savings Account Details:");
        System.out.println("Account type: "+accountType);
        System.out.println("Account Number: " + accountNumber);    // public variables are accessible everywhere
        System.out.println("Account Holder: " + accountHolder);   // protected variables are accessible in subclasses
        System.out.printf("Balance: %.2f%n", getBalance());       // private variable accessible via public getter
        System.out.println("----------------------------------");
    }
}

class Main {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount("ACC101", "Ava", 10000);
        bankAccount.displayAccount();
        bankAccount.depositAmount(2000);
        bankAccount.withdrawAmount(500);
        bankAccount.displayAccount();

        SavingsAccount savingsAccount = new SavingsAccount("SAVACC201", "Avery", 8000);
        savingsAccount.displaySavingsAccount();
        savingsAccount.depositAmount(1000);
        savingsAccount.withdrawAmount(800);
        savingsAccount.displaySavingsAccount();
    }
}