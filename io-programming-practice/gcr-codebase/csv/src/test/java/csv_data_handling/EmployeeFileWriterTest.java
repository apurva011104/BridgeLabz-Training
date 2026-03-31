package csv_data_handling;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class EmployeeFileWriterTest {
    
    @Test
    public void writeEmployeeFileTest() throws IOException{
        EmployeeFileWriter.writeEmployeeFile();
    }
}
