package junit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {
    
    @Test
    public void validatePasswordTestforValidPassword(){
        boolean actualResult = PasswordValidator.validatePassword("vAliDPasswoRd123");
        assertTrue(actualResult);
    }

    @Test
    public void validatePasswordTestforInvalidPassword(){
        boolean actualResult = PasswordValidator.validatePassword("invalidpassword");
        
        assertFalse(actualResult);
    }
}
