public class BankAccount {
    
    //Static variables
    private static String bankName = "State bank of India";
    private static int totalAccounts=0;

    //Instance variables
    private final String accountNumber;
    private String accountHolder;
    private double balance;

    //Constructor to create bank account
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++;
    }

    //Getters and setters
    public void setAccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
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

    public static String getBankName(){
        return bankName;
    }

    //Instance method to modify bank account balance - deposit
    public void depositMoney(double amountToDeposit){
        if(amountToDeposit<=0){
            System.out.println("Invalid deposit amount");
            return;
        }
        this.balance += amountToDeposit;
        System.out.printf("Deposited: $%.1f%n",amountToDeposit);
    }

    //Instance method to modify bank account balance - withdraw
    public void withdrawMoney(double amountTowithdraw){
        if(amountTowithdraw<=0 || amountTowithdraw>balance){
            System.out.println("Insufficient balance or invalid amount");
            return;
        }
        this.balance -= amountTowithdraw;
        System.out.printf("Withdrawn: $%.1f%n",amountTowithdraw);
    }

    //Static method to get total number of accounts
    public static int getTotalAccounts(){
        return totalAccounts;
    }

    public static void displayTotalAccounts(){
        System.out.println("Total number of accounts: "+totalAccounts);
    }

    //Instance method to display account details
    public void displayAccountDetails(){
        if(this instanceof BankAccount){
            System.out.println("Bank Name: "+getBankName());
            System.out.println("Account Holder: "+getAccountHolder());
            System.out.println("Account Number: "+getAccountNumber());
            System.out.printf("Balance: $%.1f%n",getBalance());
        }
        else{
            System.out.println("Invalid account instance");
        }
    }

    public static void main(String[] args) {
        
        BankAccount account1 = new BankAccount("ACC12345","Lynda Princy",1000.00);
        System.out.println("Account 1 Details: ");
        account1.displayAccountDetails();

        BankAccount account2 = new BankAccount("ACC67890", "Prince Danish", 500.00);
        System.out.println("Account 2 Details: ");
        account2.displayAccountDetails();

        displayTotalAccounts();

        System.out.println("Performing transactions on Account 1: ");
        account1.depositMoney(200.00);
        account1.withdrawMoney(150.0);
        account1.displayAccountDetails();

        account2.displayAccountDetails();
        account2.depositMoney(100.00);
        account2.withdrawMoney(900.0);
        
        
    }
}
