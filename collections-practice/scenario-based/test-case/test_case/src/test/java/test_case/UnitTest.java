package test_case;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UnitTest {
    
    Program account;

    @BeforeEach
    public void initializeAccount(){
        this.account = new Program("ACC123", 10000.0);
    }

    @Test
    public void Test_Deposit_ValidAmount(){
        double initialBalance = account.getBalance();
        double amount = 5000.0;
        account.deposit(amount);
        assertEquals( account.getBalance() , initialBalance + amount );
    }

    @Test
    public void Test_DepositNegativeAmount(){
        double amount = -5000.0;
        String exceptionMessage = "";
        try{
            account.deposit(amount);
        }
        catch(IllegalArgumentException e){
            exceptionMessage = e.getMessage();
        }

        assertEquals("Deposit amount cannot be negative" , exceptionMessage);
    }

    @Test
    public void Test_Withdraw_ValidAmount(){
        double initialBalance = account.getBalance();
        double amount = 5000.0;
        account.withdraw(amount);
        assertEquals( account.getBalance() , initialBalance - amount );
    }

    @Test
    public void Test_Withdraw_InsufficientFunds(){
        double amount = 15000.0;
        String exceptionMessage = "";
        try{
            account.withdraw(amount);
        }
        catch(IllegalArgumentException e){
            exceptionMessage = e.getMessage();
        }

        assertEquals("Insufficient funds" , exceptionMessage);
    }
}
