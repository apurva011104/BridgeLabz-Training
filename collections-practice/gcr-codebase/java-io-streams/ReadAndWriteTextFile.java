import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadAndWriteTextFile {
    public static void main(String[] args) {
        
        String fileName = "FileToRead.txt";
        String outputFile = "Output.txt";

        try(
            FileInputStream fileInputStream = new FileInputStream(fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        ){

            int character;

            System.out.println("-----------------------File content-----------------------");
            while((character = fileInputStream.read()) != -1 ){
                System.out.print((char)character);
                fileOutputStream.write(character);
            }
            System.out.println("\n-----------------------End of file-----------------------");
            System.out.println("New file created successfully");
        }
        catch(IOException e){
            System.out.println("Error occurred while copying the file.");
        }
    }
}
