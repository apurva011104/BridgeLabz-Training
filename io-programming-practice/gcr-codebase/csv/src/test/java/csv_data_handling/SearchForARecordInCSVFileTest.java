package csv_data_handling;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvValidationException;

public class SearchForARecordInCSVFileTest {
    
    @Test
    public void searchRecordFromFile()  throws IOException , CsvValidationException{
        String name = "Catherine";
        SearchForARecordInCSVFile.searchRecordFromFile(name);
    }
}
