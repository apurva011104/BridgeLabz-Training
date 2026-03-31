class BankAccount{

    private final String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void updateAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    //Method to check balance
    public void checkBalance() {
        System.out.printf("Current balance: %.2f INR%n",balance);
    }

    //Methods to modify balance - deposit
    public void deposit(double amount){
        if(amount<=0){              //Preventing overdraft
            System.out.println("Invalid deposit amount");
            return;
        }
        balance+=amount;
        System.out.printf("Amount deposited successfully. Deposited amount: %.2f INR%n",amount);
    }

    //Methods to modify balance - withdraw
    public void withdraw(double amount){
        if(amount<=0){              //Preventing overdraft
            System.out.println("Invalid withdrawal amount");
            return;
        }
        if(amount>balance){         //Preventing overdraft
            System.out.println("Insufficient balance");
            return;
        }
        balance-=amount;
        System.out.printf("Amount withdrawn successfully. Withdrawal amount: %.2f INR%n",amount);
    }
    
}

public class BankAccountManager {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("ACC1245", "Ava",5000.0);
        account1.checkBalance();
        account1.deposit(-500);
        account1.deposit(500);
        account1.checkBalance();
        account1.withdraw(8000);
        account1.withdraw(-700);
        account1.withdraw(700);
        account1.checkBalance();
    }
}
