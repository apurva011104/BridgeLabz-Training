import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        String fileName = "info.txt";

        try (
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
        ){
            String firstLine = bufferedReader.readLine();
            if(firstLine!=null){
                System.out.println(firstLine);
            }
        } 
        catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
