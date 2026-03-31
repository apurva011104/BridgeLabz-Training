package csv_data_handling;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvValidationException;

public class FilterRecordsFromCSVTest {
    
    @Test
    public void filterStudentMarks() throws IOException , CsvValidationException{
        FilterRecordsFromCSV.filterStudentMarks();
    }
}
