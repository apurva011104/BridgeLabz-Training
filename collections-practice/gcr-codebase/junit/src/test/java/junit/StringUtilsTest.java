package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {
    
    @Test
    public void reverseTest(){
        String actual_result = StringUtils.reverse("testing reverse");
        String expected_result = "esrever gnitset";

        assertEquals(expected_result, actual_result);
    }

    @Test
    public void isPalindromeTest(){
        boolean actual_result = StringUtils.isPalindrome("testing");
        boolean expected_result = false;

        assertEquals(expected_result, actual_result);

        boolean actual_result2 = StringUtils.isPalindrome("madam");
        boolean expected_result2 = true;

        assertEquals(expected_result2, actual_result2);
    }

    @Test
    public void toUpperCaseTest(){
        String actual_result = StringUtils.toUpperCase("testing uppercase");
        String expected_result = "TESTING UPPERCASE";

        assertEquals(expected_result, actual_result);
    }

}
