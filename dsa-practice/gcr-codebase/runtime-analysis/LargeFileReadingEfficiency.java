import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargeFileReadingEfficiency {

    public static void readFileUsingFileReader(String fileName){
        try {
            FileReader fileReader = new FileReader(fileName);
            try(BufferedReader bufferedReader = new BufferedReader(fileReader) ){
                String line = bufferedReader.readLine();
                while(line!=null){
                    line =  bufferedReader.readLine();
                }
                fileReader.close();
            }
            catch(IOException e){
                System.out.println(e);
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void readFileUsingInputStreamReader(String fileName){
        try(InputStreamReader reader = new InputStreamReader( new FileInputStream(fileName))){
            int data = reader.read();
            while(data != -1){
                data = reader.read();
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public static void analyze(String fileName){
        
        long fileReaderStartTime = System.nanoTime();
        readFileUsingFileReader(fileName);
        long fileReaderEndTime = System.nanoTime();
        long fileReaderTimeTaken = fileReaderEndTime - fileReaderStartTime;

        long inputStreamReaderStartTime = System.nanoTime();
        readFileUsingInputStreamReader(fileName);
        long inputStreamReaderEndTime = System.nanoTime();
        long inputStreamReaderTimeTaken = inputStreamReaderEndTime - inputStreamReaderStartTime;

        System.out.println("Analysis on "+fileName+" file: ");
        System.out.println("Time taken by fileReader: "+fileReaderTimeTaken+" nanoseconds");
        System.out.println("Time taken by inputStreamReader: "+inputStreamReaderTimeTaken+" nanoseconds");
    }

    public static void main(String[] args) {
        analyze("1MBFile.txt");
        System.out.println();
        analyze("100MBFile.txt");
    }
}
