package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {
    
    @Test
    public void celsiusToFahrenheitTest(){
        double actualResult = TemperatureConverter.celsiusToFahrenheit(45);
        double expectedResult = 113.0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void fahrenheitToCelsiusTest(){
        double actualResult = TemperatureConverter.fahrenheitToCelsius(113);
        double expectedResult = 45.0;

        assertEquals(expectedResult, actualResult);
    }


}
