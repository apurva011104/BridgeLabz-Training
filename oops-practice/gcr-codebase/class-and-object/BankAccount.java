public class BankAccount {

    private String accountHolder;
    private String accountNumber;
    private double balance;

    BankAccount(String accountHolder, String accountNumber, double balance) {
        setAccountHolder(accountHolder);
        setAccountNumber(accountNumber);
        setBalance(balance);
    }

    //Getters and setters
    public void setAccountHolder(String accountHolder){
        this.accountHolder= accountHolder;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public String getAccountHolder(){
        return accountHolder;
    }
    
    public String getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    //Method to display current balance
    public void displayCurrentBalance(){
        System.out.printf("Current balance: %.2f%n",getBalance());
    }

    //Method to deposit money
    public void depositMoney(double depositAmount){
        double newBalance = getBalance() + depositAmount;
        setBalance(newBalance);
        System.out.printf("Deposited: %.2f%n",depositAmount);
        displayCurrentBalance();
    }

    //Method to withdraw money
    public void withdrawMoney(double withdrawAmount){
        if(balance<withdrawAmount){
            System.out.println("Insufficient balance");
            return;
        }
        double newBalance = getBalance() - withdrawAmount;
        setBalance(newBalance);
        System.out.printf("Withdraw  amount: %.2f%n",withdrawAmount);
        displayCurrentBalance();
    }

    public static void main(String[] args) {
        System.out.println("State Of Chennai");
        
        BankAccount account = new BankAccount("Ava", "SOCACC1101", 700);

        account.displayCurrentBalance();
        account.depositMoney(200);
        account.withdrawMoney(100);
        account.withdrawMoney(850);
    }

}
