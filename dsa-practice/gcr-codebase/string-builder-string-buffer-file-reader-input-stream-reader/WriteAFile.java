import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class WriteAFile {
    
    public static void main(String[] args) {
        
        try(
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            FileWriter fileWriter = new FileWriter("OutputFile.txt", true);
        ){
            System.out.print("Enter text to add to file. Enter 'stop' to stop: ");
            String userInput = bufferedReader.readLine();
            while(userInput!=null && !userInput.equalsIgnoreCase("stop")){
                fileWriter.write(userInput);
                fileWriter.write(System.lineSeparator());
                System.out.print("Enter text to add to file. Enter 'stop' to stop: ");
                userInput = bufferedReader.readLine();
            }
            System.out.println("File saved successfully");

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
