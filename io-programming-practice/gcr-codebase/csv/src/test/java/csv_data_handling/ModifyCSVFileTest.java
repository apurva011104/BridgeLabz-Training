package csv_data_handling;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvValidationException;

public class ModifyCSVFileTest {

    @Test
    public void modifyCSVFile() throws IOException , CsvValidationException, NumberFormatException, ArrayIndexOutOfBoundsException{
        ModifyCSVFile.modifyCSVFile();
    }
}
