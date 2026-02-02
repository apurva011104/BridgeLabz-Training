package csv_data_handling;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvValidationException;

public class StudentFileReaderTest {
    
    @Test
    public void readStudentFileTest() throws IOException , CsvValidationException{
        StudentFileReader.readStudentFile();
    }
}
