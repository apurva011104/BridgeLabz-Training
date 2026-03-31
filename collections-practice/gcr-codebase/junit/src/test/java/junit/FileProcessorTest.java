package junit;

import org.junit.jupiter.api.Test;

public class FileProcessorTest {
    
    private String filename = "./SampleFile.txt";

    @Test
    public void writeToFileTest(){
        
        String content = "This is a sample file.\nThis file is going to be used to test File Processor class.";

        FileProcessor.writeToFile(filename, content);
    }

    @Test
    public void readFromFileTest(){

        FileProcessor.readFromFile(filename);
    }
}
