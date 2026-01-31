package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ExceptionHandlingTest {
    
    //Test method divide(int a, int b)
    @Test
    public void divideTest(){
        int result = ExceptionHandling.divide(30, 15);     //actual result
        int expected = 2;          //expected result      
        assertEquals(expected, result);
    }
    
    //Test method divide(int a, int b) to divide by 0
    @Test
    public void divideByZeroTest(){
        int result = ExceptionHandling.divide(30, 0);     //dividing by zero
    }
}
