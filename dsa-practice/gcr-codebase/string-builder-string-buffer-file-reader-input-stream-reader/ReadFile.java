import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("Sample.txt");
            try(BufferedReader bufferedReader = new BufferedReader(fileReader) ){
                String line = bufferedReader.readLine();
                while(line!=null){
                    System.out.println(line);
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
}
