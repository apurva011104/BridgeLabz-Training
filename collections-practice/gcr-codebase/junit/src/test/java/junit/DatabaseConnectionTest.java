package junit;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {

    private DatabaseConnection connection;

    @BeforeEach
    public void connectTest(){
        this.connection=new DatabaseConnection();
        connection.connect();
    }
    
    @Test
    public void getConnectionStatusTest(){
        boolean actual_result = connection.getConnectionStatus();
        boolean expected_result = true;
        assertEquals(expected_result, actual_result);
    }

    @AfterEach
    public void disconnectTest(){
        connection.disconnect();
    }
    
}
