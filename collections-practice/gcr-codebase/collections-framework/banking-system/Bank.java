import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Bank {
    
    private final Map<String, Double> accountsRecord;
    private final Queue<WithdrawalRequest> withdrawalRequestsQueue;

    public Bank() {
        this.accountsRecord = new HashMap<>();
        this.withdrawalRequestsQueue = new LinkedList<>();
    }

    public void addAccount(String accountNumber, double balance){
        if(accountsRecord.containsKey(accountNumber)){
            System.out.println("Account is already registered for this number");
            return;
        }
        accountsRecord.put(accountNumber, balance);
        System.out.println("Account added successfully for "+accountNumber);
    }

    public void deposit(String accountNumber, double depositAmount){
        if(depositAmount<=0){
            System.out.println("Invalid amount");
            return;
        }
        if(!accountsRecord.containsKey(accountNumber)){
            System.out.println("Account did not found in the record");
            return;
        }
        accountsRecord.replace(accountNumber, accountsRecord.get(accountNumber)+depositAmount);
        System.out.println("Amount deposited successfully to account: "+accountNumber+". Deposited amount: "+depositAmount+" INR");
    }

    public void requestWithdrawal(String accountNumber, double withdrawalAmount){
        if(withdrawalAmount<=0){
            System.out.println("Invalid amount.");
            return;
        }
        if (!accountsRecord.containsKey(accountNumber)) {
            System.out.println("Account did not found in the record");
            return;
        }
        WithdrawalRequest withdrawalRequest = new WithdrawalRequest(accountNumber,withdrawalAmount);
        withdrawalRequestsQueue.offer(withdrawalRequest);
        System.out.println("Withdrawal request queued for account " + accountNumber);
    }

    private void withdraw(String accountNumber, double withdrawalAmount){
        accountsRecord.replace(accountNumber, accountsRecord.get(accountNumber)-withdrawalAmount);
        System.out.println("Withdrawal successful for account "+accountNumber+". Withdrawal amount: "+withdrawalAmount+" INR");
    }

    public void processWithdrawals(){
        while(!withdrawalRequestsQueue.isEmpty()){
            WithdrawalRequest withdrawalRequest = withdrawalRequestsQueue.poll();
            String accountNumber = withdrawalRequest.getAccountNumber();
            double withdrawalAmount = withdrawalRequest.getAmount();

            double balance = accountsRecord.get(accountNumber);
            if(balance>=withdrawalAmount){
                withdraw(accountNumber, withdrawalAmount);
            }
            else{
                System.out.println("Insufficient balance for account "+accountNumber+". Withdrawal request failed.");
            }
        }
    }

    public void displaySortedByBalance(){
        TreeMap<Double, List<String>> sorted = new TreeMap<>();
        for(Map.Entry<String, Double> entry : accountsRecord.entrySet()){
            sorted.putIfAbsent(entry.getValue(), new ArrayList<>());
            sorted.get(entry.getValue()).add(entry.getKey());
        }

        System.out.println("All accounts (sorted by balance): ");

        for(Map.Entry<Double, List<String>> entry: sorted.entrySet()){
            for(String account: entry.getValue()){
                System.out.println("Account Number: "+account+", Balance: "+entry.getKey()+" INR");
            }
        }
    }
}
