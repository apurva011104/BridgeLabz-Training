package csv_data_handling;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvValidationException;

public class SortCSVRecordsByAColumnTest {
    
    @Test
    public void sortCSVRecordsByAColumn() throws IOException , CsvValidationException, NumberFormatException, ArrayIndexOutOfBoundsException{
        SortCSVRecordsByAColumn.sortCSVRecordsByAColumn();
    }
}
