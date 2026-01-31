package junit;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class LongRunningTaskTest {
    

    @Timeout(5)
    @Test
    public void longRunningTaskTest() throws InterruptedException{
        int actualResult = LongRunningTask.longRunningTask();
        int expectedResult = (int)Math.pow(2, 30);

        assertEquals(expectedResult, actualResult);
    
    }

    @Timeout(value=2, unit=TimeUnit.SECONDS)
    @Test
    public void longRunningTaskTestTimeout() throws InterruptedException{
        LongRunningTask.longRunningTask();
    
    }
}
