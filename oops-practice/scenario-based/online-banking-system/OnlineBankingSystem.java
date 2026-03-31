public class OnlineBankingSystem {
    

    public static void main(String[] args) {

        Bank bank = new Bank();

        Account account1 = new SavingsAccount("Ava", 5000);
        Account account2 = new CurrentAccount("Rose", 7500);

        bank.createAccount(account1);
        bank.createAccount(account2);

        bank.transferAmount(account1, account2, 500);
        
        bank.transferAmount(account1, account2, 500);

        account1.printTransactionHistory();
        account2.printTransactionHistory();
    }

}
