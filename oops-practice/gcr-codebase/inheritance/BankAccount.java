public class BankAccount {

    final String accountID;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountId, String accountHolder, double balance) {
        this.accountID = accountId;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    //Method to access balance
    public double getBalance(){
        return balance;
    }

    //Method to modify balance - deposit
    public void deposit(double depositAmount){
        if(depositAmount<=0){
            System.out.println("Invalid deposit amount.");
            return;
        }
        balance += depositAmount;
        System.out.printf("Deposited amount: $%.2f%n",depositAmount);
    }

    //Method to modify balance - withdraw
    public void withdraw(double withdrawalAmount){
        if(withdrawalAmount<=0){
            System.out.println("Invalid withdrawl amount.");
            return;
        }
        if(withdrawalAmount>balance){
            System.out.println("Insufficient balance.");
            return;
        }
        balance-=withdrawalAmount;
        System.out.printf("Amount withdrawed: $%.2f%n",withdrawalAmount);
    }

    public void displayAccountInfo(){
        System.out.println("Account Id: "+accountID);
        System.out.println("Account holder: "+accountHolder);
        System.out.println("Balance: "+balance);
    }

}

class SavingsAccount extends BankAccount{

    private double interestRate;

    public SavingsAccount(String accountId, String accountHolder, double balance, double interestRate){
        super(accountId, accountHolder, balance);
        this.interestRate = interestRate;
    }

    //getters and setters for interest rate
    public double getInterestRate(){
        return interestRate;
    }
    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    public void addInterest(){
        double interest = (getBalance() * interestRate) / 100;
        deposit(interest);
    }

    public void displayAccountType(){
        System.out.println("Account type: Savings Account");
    }

    @Override
    public void displayAccountInfo(){
        displayAccountType();
        super.displayAccountInfo();
        System.out.printf("Interest Rate: %.2f%%%n",interestRate);
    }
}


class CheckingAccount extends BankAccount{

    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, String accountHolder, double balance, double withdrawalLimit) {
        super(accountNumber,accountHolder, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    //getters and setters for withdrawal limit
    public double getWithdrawalLimit(){
        return withdrawalLimit;
    }
    public void setWithdrawalLimit(double withdrawalLimit){
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void withdraw(double withdrawalAmount){
        if(withdrawalAmount>withdrawalLimit){
            System.out.println("Withdrawal amount more than withdrawal limit");
            return;
        }
        super.withdraw(withdrawalAmount);
    }

    public void displayAccountType(){
        System.out.println("Account type:Checking Account");
    }

    @Override
    public void displayAccountInfo(){
        displayAccountType();
        super.displayAccountInfo();
        System.out.printf("Withdarwal limit: $%.2f%n",withdrawalLimit);
    }

}

class FixedDepositAccount extends BankAccount{

    private int tenureInYears;

    public FixedDepositAccount(String accountId, String accountHolder, double balance, int tenureInYears){
        super(accountId, accountHolder, balance);
        this.tenureInYears = tenureInYears;
    }

    //Getter and setters for tenure
    public void setTenureInYears(int tenureInYears){
        this.tenureInYears = tenureInYears;
    }
    public int getTenureInYears(){
        return tenureInYears;
    }

    public void displayAccountType(){
        System.out.println("Account type: Fixed Deposit Account");
    }

    @Override
    public void displayAccountInfo(){
        displayAccountType();
        super.displayAccountInfo();
        System.out.println("Tenure in years: "+tenureInYears);
    }
}

//Main class for testing
class Main{
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("ACC0101", "Avery", 500.0);
        SavingsAccount savingsAccount1 = new SavingsAccount("SAVACC0147","Ava",278.00,10);
        CheckingAccount checkingAccount1 = new CheckingAccount("CHKACC0075","Lily",750.0,100.0);
        FixedDepositAccount fixedDepositAccount1 = new FixedDepositAccount("FDACC0185","Violet",470.0,5);

        //Calling methods of normal bank account
        bankAccount1.displayAccountInfo();
        bankAccount1.deposit(25.0);
        bankAccount1.withdraw(67.0);
        
        System.out.println();

        //Calling methods of savings account
        savingsAccount1.displayAccountInfo();
        savingsAccount1.addInterest();
        savingsAccount1.deposit(18);
        savingsAccount1.withdraw(47);

        System.out.println();

        //Calling methods of checking account
        checkingAccount1.displayAccountInfo();
        checkingAccount1.deposit(58);
        checkingAccount1.withdraw(240);
        checkingAccount1.withdraw(28);

        System.out.println();

        //Calling methods of fixed depositaccount
        fixedDepositAccount1.displayAccountInfo();
        fixedDepositAccount1.deposit(48);
        fixedDepositAccount1.withdraw(14);
    }
}