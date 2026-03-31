import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertByteStreamToCharacterStream {
    public static void main(String[] args) {

        try {
            FileInputStream fileInputStream = new FileInputStream("Sample.txt");
            try(InputStreamReader streamReader = new InputStreamReader(fileInputStream, "UTF-8")) {
                try(BufferedReader bufferedReader = new BufferedReader(streamReader)){
                    String line = bufferedReader.readLine();
                    while(line!=null){
                        System.out.println(line);
                        line =  bufferedReader.readLine();
                    }
                    fileInputStream.close();
                }
                catch(IOException e){
                    System.out.println(e);
                }
            } 
            catch (IOException e) {
                System.out.println(e);
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
        
    }
}
