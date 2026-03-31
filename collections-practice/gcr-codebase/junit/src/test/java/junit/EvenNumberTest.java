package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenNumberTest {
    
    @ParameterizedTest
    @ValueSource(ints={ 2, 4, 6, 7, 9})
    public void isEvenTest(int number){
        boolean actualResult = EvenNumber.isEven(number);
        boolean expectedResult = number%2==0;

        assertEquals(expectedResult, actualResult);

    }
}
