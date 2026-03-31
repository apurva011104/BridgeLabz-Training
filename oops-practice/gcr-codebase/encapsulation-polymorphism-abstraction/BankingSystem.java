interface Loanable{
    public void applyForLoan(double amount);
    public boolean calculateLoanEligibility(double amount);
}

abstract class BankAccount implements Loanable{
    
    private final String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setName(String holderName) {
        this.holderName = holderName;
    }

    public double checkBalance() {
        return balance;
    }

    //Concrete method to modify balance - deposit
    public void deposit(double amount){
        if(amount<=0){         
            System.out.println("Invalid deposit amount");
            return;
        }
        balance+=amount;
        System.out.printf("Amount deposited successfully. Deposited amount: %.2f INR%n",amount);
    }

    //Concrete method to modify balance - withdraw
    public void withdraw(double amount){
        if(amount<=0){          
            System.out.println("Invalid withdrawal amount");
            return;
        }
        if(amount>balance){
            System.out.println("Insufficient balance");
            return;
        }
        balance-=amount;
        System.out.printf("Amount withdrawn successfully. Withdrawal amount: %.2f INR%n",amount);
    }

    protected abstract double calculateInterest();

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility(amount)) {
            System.out.println("Loan approved for Account Number "+getAccountNumber()+": " + amount);
        } else {
            System.out.println("Loan denied");
        }
    }

    //Concrete method to display account info
    public void displayInfo(){
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Account Holder Name: "+holderName);
        System.out.printf("Current Balance: %.2f INR%n",balance);
    }
    
}


class SavingsAccount extends BankAccount{

    private static final double INTEREST_RATE_PERCENTAGE = 7;

    SavingsAccount(String accountNumber, String holderName, double balance){
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return (checkBalance() * INTEREST_RATE_PERCENTAGE)/100;
    }

    @Override
    public boolean calculateLoanEligibility(double amount) {
        return checkBalance() >= amount * 0.3;
    }
}

class CurrentAccount extends BankAccount{

    private static final double INTEREST_RATE_PERCENTAGE = 3;

    CurrentAccount(String accountNumber, String holderName, double balance){
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return (checkBalance() * INTEREST_RATE_PERCENTAGE)/100;
    }

    @Override
    public boolean calculateLoanEligibility(double amount) {
        return checkBalance() >= amount;
    }


}

public class BankingSystem {
    
    public static void main(String[] args) {
        
        BankAccount account1 = new CurrentAccount("CACC145782","Ava",10000);
        BankAccount account2 = new SavingsAccount("SACC782436","Daisy",7400);
        SavingsAccount account3 = new SavingsAccount("SACC742659","Mia",5700);
        CurrentAccount account4 = new CurrentAccount("CACC758627", "Bella", 8000);

        BankAccount[] accounts ={account1,account2,account3,account4};

        for(BankAccount account: accounts){
            account.displayInfo();
            account.deposit(1000);
            account.withdraw(7000);
            System.out.printf("Calculated Interest: %.2f INR%n", account.calculateInterest());
            account.displayInfo();
            account.calculateLoanEligibility(2000);
            System.out.println();
        }
    }

}
