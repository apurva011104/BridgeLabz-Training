import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        
        String fileName = "Data.txt";

        try(
            FileReader fileReader = new FileReader(fileName);
        ) {
            int data;
            while((data = fileReader.read()) != -1){
                System.out.println((char)data);
            }
        } 
        catch (IOException e) {
            System.out.println("File not found.");
        }
    }
}
