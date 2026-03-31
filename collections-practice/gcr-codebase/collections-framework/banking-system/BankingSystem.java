public class BankingSystem {
    
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addAccount("ACC123",5820 );
        bank.addAccount("ACC456", 95480);
        bank.addAccount("ACC789", 50140);
        bank.addAccount("ACC147", 27000);
        bank.addAccount("ACC258", 36705);

        bank.displaySortedByBalance();

        bank.deposit("ACC123", 25000);

        bank.requestWithdrawal("ACC456",25000);
        bank.requestWithdrawal("ACC147",5000);
        bank.requestWithdrawal("ACC258",50000);

        bank.processWithdrawals();

        bank.displaySortedByBalance();
    }

}
