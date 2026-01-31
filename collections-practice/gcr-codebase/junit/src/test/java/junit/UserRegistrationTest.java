package junit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {
    
    UserRegistration userRegistration;

    @BeforeEach
    public void initializeUserRegistration(){
        this.userRegistration = new UserRegistration();
    }

    @Test
    public void registerUserTest(){
        userRegistration.registerUser("itz.ava", "ava@google","Apurva123");
    }

    @Test
    public void registerUserTestForInvalidEmail(){
        assertThrows(IllegalArgumentException.class, ()->{
            userRegistration.registerUser("itz.ava", "ava", "Apurva123");
        });
    }

    @Test
    public void registerUserTestForInvalidPassword(){
        assertThrows(IllegalArgumentException.class, ()->{
            userRegistration.registerUser("itz.ava", "ava@google", "apurva123");
        });
    }

    @Test
    public void registerUserTestForInvalidUsername(){
        assertThrows(IllegalArgumentException.class, ()->{
            userRegistration.registerUser("itz.ava_", "ava@google", "Apurva123");
        });
    }
}
