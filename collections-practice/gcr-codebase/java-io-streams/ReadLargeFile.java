import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeFile {
    
    public static void main(String[] args) {
        
        String fileName = "500MB.txt";
        
        try (
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
        ){
            String line;
            System.out.println("File reading started.");
            while((line = bufferedReader.readLine())!=null){
                if(line.toLowerCase().contains("error")){
                    System.out.println(line);
                }
            }
            System.out.println("File reading completed successfully.");
        } 
        catch (IOException e) {
        }
    }
}
