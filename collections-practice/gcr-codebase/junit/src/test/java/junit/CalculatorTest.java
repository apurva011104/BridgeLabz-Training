package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    //Test method add(int a, int b)
    @Test
    public void addTest(){
        int result = Calculator.add(8, 15);     //actual result
        int expected = 23;          //expected result      
        assertEquals(expected, result);

    }

    //Test method multiply(int a, int b)
    @Test
    public void multiplyTest(){
        int result = Calculator.multiply(8, 15);     //actual result
        int expected = 120;          //expected result      
       assertEquals(expected, result);

    }

    //Test method subtract(int a, int b)
    @Test
    public void subtractTest(){
        int result = Calculator.subtract(8, 15);     //actual result
        int expected = -7;          //expected result      
        assertEquals(expected, result);

    }

    //Test method divide(int a, int b)
    @Test
    public void divideTest(){
        int result = Calculator.divide(30, 15);     //actual result
        int expected = 2;          //expected result      
        assertEquals(expected, result);
    }
    
    //Test method divide(int a, int b) to divide by 0
    @Test
    public void divideByZeroTest(){
        int result = Calculator.divide(30, 0);     //dividing by zero
    }

}
