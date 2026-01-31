package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    
    private BankAccount account;

    @BeforeEach
    public void initializeAccount(){
        this.account = new BankAccount("ACC12345", 5000.00);
        System.out.println("Account created successfully");
    }

    @Test
    public void getBalanceTest(){
        double expectedBalance = 5000.00;
        double actualBalance = account.getBalance();

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void depositTest(){
        account.deposit(5000.00);
        double expectedBalance = 10000.00;
        double actualBalance = account.getBalance();

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void depositTestForIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, ()->{
            account.deposit(0);
        });
    }

    @Test
    public void withdrawalTest() throws InsufficientBalanceException{

        account.withdraw(1000.00);
        double expectedBalance = 4000.00;
        double actualBalance = account.getBalance();

        assertEquals(expectedBalance, actualBalance);
    
    }

    @Test
    public void withdrawTestForIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, ()->{
            account.withdraw(0);
        });
    }

     @Test
    public void withdrawTestForInsufficientBalanceException(){
        assertThrows(InsufficientBalanceException.class, ()->{
            account.withdraw(10000.00);
        });
    }
}

