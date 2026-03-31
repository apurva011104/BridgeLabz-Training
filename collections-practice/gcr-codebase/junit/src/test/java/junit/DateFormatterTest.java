package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {
    
    @Test
    public void formatDateTestForValidDate(){
        String actualResult=DateFormatter.formatDate("2026-01-15");
        String expectedResult= "15-01-2026";

        assertEquals(expectedResult, actualResult); 
    }

    @Test
    public void formatDateTestForInvalidDate(){
        assertThrows(IllegalArgumentException.class, ()->{
            DateFormatter.formatDate("32-01-2026");
        });
    }
}
